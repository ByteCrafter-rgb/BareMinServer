# 🏁 HTTP Reflection: Mental Wiring Complete

`ncat -l 9000`

### ✅ Goal: See HTTP as Plain Text

I successfully bypassed high-level APIs to interact with the raw protocol.

### 🛠️ The Deliverables

- **Raw Request:** Observed the client sending a Request Line (`GET /hello HTTP/1.1`) followed by Headers.
- **Raw Response:** Observed the server returning a Status Line (`HTTP/1.1 200 OK`), Headers, and an HTML Body.
- **The "Invisible" Rules:** Confirmed via Wireshark that the TCP Handshake (`SYN`, `SYN-ACK`, `ACK`) must happen before text is exchanged.

### 🧠 Key Concept: The Anatomy of a Message

HTTP is simply **formatted text** governed by specific **rules**:

1.  **Start Line:** The "What" (Method/Path or Status).
2.  **Headers:** The "Metadata" (Key-Value pairs like `Content-Type`).
3.  **The Blank Line:** The "Separator" (`\r\n`). Without this, the server hangs because it doesn't know the headers have ended.
4.  **Body:** The "Payload" (The actual data or HTML).

### 🚦 Protocol Logic

- **Line-Based:** The server uses `readLine()` because HTTP/1.1 headers are terminated by newlines.
- **Stateless but Sequential:** The server waits for the full request before generating the response.
