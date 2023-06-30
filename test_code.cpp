#include "rtspserver.h"
#include "rtspNodeMsgId.h"
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/ioctl.h>
#include <netinet/in.h>
#include <net/if.h>
#include <arpa/inet.h>
#include <thread>
#include <cstdlib>
#include <iostream>
#include <cstring>
#include <cerrno>
#include <stdexcept>
#include <string> // Add this line for the string header
#include <gst/gst.h>
using namespace std;
std::string getIPAddress(const char* interfaceName);
int main() {
    const char* interfaceName = "wlp0s20f3"; // Replace with the interface name connected in Raspberry Pi
    std::string ip;

    try {
        ip = getIPAddress(interfaceName);
    } catch (const std::exception& e) {
        std::cerr << "Error retrieving IP address: " << e.what() << std::endl;
        return 1;
    }

    // Set the default RTSP port to 8554
    int port = 8554;

    // Get the stream name from the user
    std::string streamName = "teststream";

    // Create an instance of RtspServer
    RtspServer server(ip, port, streamName);
    
    MessageId m = MessageId::CONNECTION_REQUEST;
    server.process(static_cast<int>(m));

    // Print server details
    std::cout << "**RTSP SERVER USING GSTREAMER**\n";
    MessageId mess = MessageId::IP_ADDRESS_PORT;
    server.process(static_cast<int>(mess));
   

    // Wait for a moment to allow the server to start
    std::this_thread::sleep_for(std::chrono::seconds(1));

    // Start the RTSP server
    int startMsg = static_cast<int>(MessageId::START_RTSP_SERVER);
     server.process(startMsg);
    

    // Run the RTSP server
    server.runServer();

    return 0;
}

