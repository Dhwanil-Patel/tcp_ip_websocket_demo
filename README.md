# tcp_ip_websocket_demo

Server:
- Start server with defined port in command line.
- Configure server socket with that port.
- Call start listening method
- serverSocket.accept() registered as server is in listening mode

Client:
- Register Socket with server port and ip

Server:
- Get accept call
- Call RequestProcessor Register & call thread run method.
- Call start listeing method in server
- Request processor's InputStream method (via server)
- Client's OutputStream method
- Request processor's collect request data print server data he get and send response

For execute,
- Server : In program argument, 5050
- Client : In program argument, 127.0.0.1 5050 101 Dhwanil Male
