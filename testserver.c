/* GStreamer
 * Copyright (C) 2008 Wim Taymans <wim.taymans at gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

#include <stdio.h>
#include <gst/gst.h>
#include <gst/rtsp-server/rtsp-server.h>

/* define this if you want the resource to only be available when using
 * user/admin as the password */
#undef WITH_AUTH

/* this timeout is periodically run to clean up the expired sessions from the
 * pool. This needs to be run explicitly currently but might be done
 * automatically as part of the mainloop. */
static gboolean
timeout (GstRTSPServer * server, gboolean ignored)
{
  GstRTSPSessionPool *pool;

  pool = gst_rtsp_server_get_session_pool (server);
  gst_rtsp_session_pool_cleanup (pool);
  g_object_unref (pool);

  return TRUE;
}

int
main (int argc, char *argv[])
{
  GMainLoop *loop;
  GstRTSPServer *server;
  GstRTSPMountPoints *mounts;
  GstRTSPMediaFactory *factory;
#ifdef WITH_AUTH
  GstRTSPAuth *auth;
  gchar *basic;
#endif

printf("JKS test is starting");
  gst_init (&argc, &argv);

  loop = g_main_loop_new (NULL, FALSE);

  /* create a server instance */
  server = gst_rtsp_server_new ();

  /* get the mount points for this server, every server has a default object
   * that be used to map uri mount points to media factories */
  mounts = gst_rtsp_server_get_mount_points (server);

#ifdef WITH_AUTH
  /* make a new authentication manager. it can be added to control access to all
   * the factories on the server or on individual factories. */
  auth = gst_rtsp_auth_new ();
  basic = gst_rtsp_auth_make_basic ("user", "admin");
  gst_rtsp_auth_set_basic (auth, basic);
  g_free (basic);
  /* configure in the server */
  gst_rtsp_server_set_auth (server, auth);
#endif

  /* make a media factory for a test stream. The default media factory can use
   * gst-launch syntax to create pipelines.
   * any launch line works as long as it contains elements named pay%d. Each
   * element with pay%d names will be a stream */
  factory = gst_rtsp_media_factory_new ();

  char *pipeline="videotestsrc ! video/x-raw,format=I420,width=320,height=240,framerate=10/1 ! jpegenc ! rtpjpegpay name=pay0 pt=26 ";
  printf("JKS pipeline is %s\n",pipeline);
  gst_rtsp_media_factory_set_launch (factory, "( "
          "videotestsrc ! video/x-raw,format=I420,width=320,height=240,framerate=10/1 ! jpegenc ! rtpjpegpay name=pay0 pt=26 "
          ")");
  /*gst_rtsp_media_factory_set_launch (factory, "( "
       "v4l2src !video/x-raw-yuv,width=128,height=96,format='(fourcc)'UYVY ! videoconvert ! ffenc_h263 ! video/x-h263 ! rtph263ppay pt=96 ! udpsink "
          ")");  */    
   

  /* attach the test factory to the /test url */
  gst_rtsp_mount_points_add_factory (mounts, "/testrtspserver", factory);

  /* don't need the ref to the mounts anymore */
  g_object_unref (mounts);

  /* attach the server to the default maincontext */
  if (gst_rtsp_server_attach (server, NULL) == 0)
    goto failed;

  /* add a timeout for the session cleanup */
  g_timeout_add_seconds (2, (GSourceFunc) timeout, server);

  /* start serving, this never stops */
  g_main_loop_run (loop);

  return 0;

  /* ERRORS */
failed:
  {
    g_print ("failed to attach the server\n");
    return -1;
  }
}

