#include "rtspserver.h"
#include "rtspNodeMsgId.h"
#include <unistd.h>
#include <string.h> /* For strncpy */
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/ioctl.h>
#include <netinet/in.h>
#include <net/if.h>
#include <arpa/inet.h>
#include <thread>
#include <cstdlib>
#include <gst/gst.h>
#include <exception> // Add this header for std::exception
#include <stdexcept> // Add this header for std::runtime_error
using namespace std;
class CustomException : public std::exception {
private:
    std::string message;

public:
    explicit CustomException(const std::string& msg) : message(msg) {}

    const char* what() const noexcept override {
        return message.c_str();
    }
};

std::string getIPAddress(const char* interfaceName);

std::string getIPAddress(const char* interfaceName) {
    int fd = socket(AF_INET, SOCK_DGRAM, 0);
    if (fd < 0) {
        throw CustomException("Error creating socket"); // 
    }

    struct ifreq ifr;
    ifr.ifr_addr.sa_family = AF_INET;
    strncpy(ifr.ifr_name, interfaceName, IFNAMSIZ - 1);

    if (ioctl(fd, SIOCGIFADDR, &ifr) < 0) {
        close(fd);
        throw CustomException("Error in ioctl call"); // 
    }

    close(fd);

    string ip = inet_ntoa(((struct sockaddr_in *)&ifr.ifr_addr)->sin_addr);

    return ip;
}

int RtspServer::process(int msg) {
    MessageId msg_id = static_cast<MessageId>(msg);
    switch (msg_id) {
        case MessageId::MSG_ID_START_PIPELINE:
            std::cout << "\n\t[MESSAGE]Received message to start the pipeline." << std::endl;
            // Process the message to start the pipeline
              // Run the RTSP server
       
            break;
        case MessageId::MSG_ID_STOP_PIPELINE:
            std::cout << "\n\t[MESSAGE]Received message to stop the pipeline." << std::endl;
            // Process the message to stop the pipeline
            break;
        case MessageId::START_RTSP_SERVER:
            std::cout << "\n\t[RTSP]Received message to start the RTSP server." << std::endl;
            // Process the message to start the RTSP server
            // Start the RTSP server
             startServer();
            break;
        case MessageId::STOP_RTSP_SERVER:
            std::cout << "\n\t[RTSP]Received message to stop the RTSP server." << std::endl;
            // Process the message to stop the RTSP server
            break;
        case MessageId::CONNECTION_REQUEST:
            std::cout << "\n\t[MESSAGE]Received connection request." << std::endl;
            // Process the connection request
            break;
        case MessageId::IP_ADDRESS_PORT:
            std::cout << "\n\t[MESSAGE]Received IP address and port information." << std::endl;
            print();

            // Process the IP address and port information
            break;
        default:
            std::cout << "\n\t[ERROR MESSAGE]Unknown message received." << std::endl;
            break;
    }
    return 0;
}


void RtspServer::runServer() {
    // Create GStreamer pipeline
    std::string pipeline = "videotestsrc ! jpegenc ! jpegdec ! ";
    pipeline += " autovideosink location=/" + streamName;

    // Initialize GStreamer
    gst_init(nullptr, nullptr);

    // Create GStreamer elements
    GstElement* pipelineElement = gst_parse_launch(pipeline.c_str(), nullptr);

    // Set the 'port' property on the pipeline
    //g_object_set(pipelineElement, "port", port, nullptr);

    // Start the pipeline
    gst_element_set_state(pipelineElement, GST_STATE_PLAYING);
    int start_mess = static_cast<int>(MessageId::MSG_ID_START_PIPELINE);
    process(start_mess);

    // Wait for a signal to stop the server
    std::cout << "\n//////////////////////////////////////////////////RTSP server running. Press Ctrl+C to stop./////////////////////////////////////////////////\n" << std::endl;
    g_main_loop_run(g_main_loop_new(nullptr, false));

    // Stop the pipeline
    int start_mess1 = static_cast<int>(MessageId::MSG_ID_STOP_PIPELINE);
    process(start_mess1);
    gst_element_set_state(pipelineElement, GST_STATE_NULL);

    // Cleanup GStreamer
    gst_object_unref(pipelineElement);
    gst_deinit();
}

void RtspServer::startServer() {
    rtspServerFd = socket(AF_INET, SOCK_STREAM, 0);
    if (rtspServerFd < 0) {
        std::cout << "\n\t**Error in server creating**\n" << std::endl;
        int start_mess2 = 0;
        process(start_mess2);
    } else {
        std::cout << "\n\t**Server Created**\n" << std::endl;
        
    }
}



