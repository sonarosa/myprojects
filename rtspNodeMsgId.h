/*#ifndef RTSPNODEMSGID_H
#define RTSPNODEMSGID_H

// Message IDs
const int START_PIPELINE_MSG_ID = 1;
const int STOP_PIPELINE_MSG_ID = 2;
const int START_RTSP_SERVER_MSG_ID = 3;
const int STOP_RTSP_SERVER_MSG_ID = 4;
const int CONNECTION_REQUEST_MSG_ID = 5;
const int IP_ADDRESS_PORT_MSG_ID = 6;


#endif // RTSPNODEMSGID_H
*/
#ifndef RTSPNODEMSGID_H
#define RTSPNODEMSGID_H

enum class MessageId {
    MSG_ID_START_PIPELINE = 1,
    MSG_ID_STOP_PIPELINE,
    START_RTSP_SERVER,
    STOP_RTSP_SERVER,
    CONNECTION_REQUEST,
    IP_ADDRESS_PORT
};

#endif // RTSPNODEMSGID_H

