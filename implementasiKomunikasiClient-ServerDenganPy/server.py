import socket as sc;

HOST = '127.0.0.1'   # Alamat IP lokal (localhost)
PORT = 65432 

# Membuat socket tcp

server_socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM)
server_socket.bind((HOST, PORT))
server_socket.listen()

print(f"Server berjalan di {HOST}:{PORT}, menunggu koneksi...")

# Menerima koneksi dari client
conn, addr = server_socket.accept()
print(f"Terhubung dengan client: {addr}")

# Menerima pesan dari client
data = conn.recv(1024).decode()
print(f"Pesan dari client: {data}")

# Mengirim balasan ke client
response = "Pesan diterima oleh server!"
conn.sendall(response.encode())

# Tutup koneksi
conn.close()
server_socket.close()

