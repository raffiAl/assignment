import socket
import threading

# List untuk menyimpan semua koneksi client
clients = []

def handle_client(conn, addr):
    print(f"[TERHUBUNG] {addr}")
    while True:
        try:
            msg = conn.recv(1024).decode("utf-8")
            if not msg:
                break
            print(f"[{addr}] {msg}")
            broadcast(msg, conn)
        except:
            break
    # Jika koneksi terputus
    print(f"[PUTUS] {addr}")
    clients.remove(conn)
    conn.close()

def broadcast(message, sender_conn):
    for client in clients:
        if client != sender_conn:
            try:
                client.send(message.encode("utf-8"))
            except:
                client.close()
                clients.remove(client)

def start_server():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(("127.0.0.1", 5555))  # host & port
    server.listen()
    print("[SERVER BERJALAN] Menunggu koneksi...")

    while True:
        conn, addr = server.accept()
        clients.append(conn)
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()

if __name__ == "__main__":
    start_server()
