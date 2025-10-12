import socket as sc;

# Konfigurasi client
HOST = '127.0.0.1'   # Alamat IP server
PORT = 65432         # Port server

# Membuat socket TCP
client_socket = sc.socket(sc.AF_INET, sc.SOCK_STREAM)
client_socket.connect((HOST, PORT))

# Mengirim pesan ke server
message = "Halo server, ini pesan dari client!"
client_socket.sendall(message.encode())

# Menerima balasan dari server
data = client_socket.recv(1024).decode()
print(f"Balasan dari server: {data}")

# Tutup koneksi
client_socket.close()
