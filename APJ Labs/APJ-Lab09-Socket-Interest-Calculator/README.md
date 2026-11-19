# APJ Lab 9: Simple Interest Calculator (Client-Server)

Application Programming in Java, INHA University in Tashkent, Fall 2026.

Socket programming with `ServerSocket` and `Socket`. The client reads the principal, the yearly interest rate and the duration from the user, sends them to the server with `DataOutputStream`, and displays the simple interest the server sends back. The server reads the three values with `DataInputStream` in the same order, calculates `P * R * T / 100`, replies, and waits for the next client.

**Run:** start `SimpleInterestCalculatorServer` first (port 8000), then run `SimpleInterestCalculatorClient` in a second window.
