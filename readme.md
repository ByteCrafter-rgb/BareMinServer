# 📋 Web Server Fundamentals: Revision Summary

---

### 1. The TCP Handshake 🤝

- **Purpose:** To establish a reliable "pipe" before any data is sent.
- **The 3-Step Process:**
  1.  **SYN (Synchronize):** Browser knocks on port 9000.
  2.  **SYN-ACK:** Server says "I'm here and ready."
  3.  **ACK (Acknowledge):** Browser confirms, and the pipe is open.
- **Ports:** The Server uses a static port (e.g., **9000**); the Browser uses a random temporary port (e.g., **53876**).

### 2. The HTTP Request ✉️

- **Request Line:** The first line defining the intent: `GET /index.html HTTP/1.1`.
- **Headers:** Metadata like `User-Agent` (Browser/OS identity) and `Host`.
- **The Terminator:** A blank line (`\r\n\r\n`) that tells the server "I'm done sending headers; start processing."

### 3. The Server Response 📤

- **Status Line:** The first line of the reply: `HTTP/1.1 200 OK`.
- **MIME Types:** The `Content-Type` header (e.g., `text/html`, `image/jpeg`) tells the browser how to render the bytes.
- **Byte Transfer:** Files are read as `byte[]` arrays so the server can handle any file type (text or binary).

### 4. Connection Termination 🏁

- **FIN Flag:** One side says "I have no more data to send."
- **ACK Flag:** The other side acknowledges the "hang up" request.
- **Lifecycle:** In basic servers, the connection closes immediately after one response.
