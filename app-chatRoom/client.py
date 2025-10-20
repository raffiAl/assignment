import socket
import threading

def receive_messages(sock):
    while True:
        try:
            msg = sock.recv(1024).decode("utf-8")
            if msg:
                print(f"\nPesan: {msg}")
        except:
            print("Koneksi ke server terputus.")
            sock.close()
            break

def start_client():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        client.connect(("127.0.0.1", 5555))
    except:
        print("Gagal terhubung ke server.")
        return

    print("Terhubung ke server. Ketik pesan Anda:")

    # Thread untuk menerima pesan
    thread = threading.Thread(target=receive_messages, args=(client,))
    thread.start()

    # Loop untuk mengirim pesan
    while True:
        msg = input("")
        if msg.lower() == "exit":
            client.close()
            break
        try:
            client.send(msg.encode("utf-8"))
        except:
            print("Gagal mengirim pesan. Koneksi terputus.")
            break

if __name__ == "__main__":
    start_client()
