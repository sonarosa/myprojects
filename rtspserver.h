#ifndef RTSPSERVER_H
#define RTSPSERVER_H

#include <string>
#include <iostream>
#include "rtspNodeMsgId.h"

// Virtual base class
class Node {
public:
    virtual void print() = 0;
    virtual int process(int msg) = 0;
};

// RTSP server class
class RtspServer : public Node {
private:
    std::string ipAddress;
    int port;
    std::string streamName;
    int  rtspServerFd;

public:
    RtspServer(const std::string& ip, int p, const std::string& name) : ipAddress(ip), port(p), streamName(name) {}

    void print() override {
        std::cout << "RTSP server address: rtsp://" << ipAddress << ":" << port << "/" << streamName << std::endl;
        std::cout << "Port: " << port << std::endl;
        std::cout << "Stream name: " << streamName << std::endl;
    }

    int process(int msg) override;
    void runServer();
    void startServer();
    //std::string getIPAddress(const char* interfaceName);   
};

#endif // RTSPSERVER_H

