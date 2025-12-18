require('dotenv').config(); // Baca file .env
const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

// 2. Import "database" palsu kita
const { activities } = require('./data/fakeDB');

// 3. Inisialisasi aplikasi Express
const app = express();
app.use(express.json()); // Middleware untuk baca JSON dari request body

// --- PENGELOLAAN DATA DI MEMORI (PINDAHKAN KE SINI AGAR LEBIH JELAS) ---
// Ini adalah "database" kita, sebenarnya hanya array di memori.
let users = [];
let userIdCounter = 1; // Counter untuk membuat ID unik
// -------------------------------------------------------------------------

const PORT = process.env.PORT || 3000;

// 4. Buat Endpoint Registrasi
app.post('/api/register', async (req, res) => {
    console.log(">>> Menerima request di /api/register dengan body:", req.body); // Tambah log ini

    const { username, password, role = 'student' } = req.body;

    // Validasi input
    if (!username || !password) {
        console.log(">>> Validasi gagal: username atau password kosong.");
        return res.status(400).json({ message: 'Username dan password harus diisi' });
    }

    // Cek apakah username sudah ada di array `users`
    const existingUser = users.find(u => u.username === username);
    if (existingUser) {
        console.log(`>>> Registrasi gagal: username '${username}' sudah ada.`);
        return res.status(409).json({ message: 'Username sudah terdaftar' });
    }

    try {
        console.log(">>> Mencoba mengenkripsi password...");
        // Enkripsi password sebelum disimpan
        const hashedPassword = await bcrypt.hash(password, 10);
        console.log(">>> Password berhasil dienkripsi.");

        // Buat objek user baru
        const newUser = {
            id: userIdCounter++, // Gunakan counter lalu increment
            username,
            password: hashedPassword,
            role
        };

        // Tambahkan user baru ke array `users`
        users.push(newUser);
        console.log(">>> User baru berhasil ditambahkan ke array 'users'. Total user:", users.length);

        // Kembalikan response sukses (jangan kirim password!)
        res.status(201).json({ message: 'User berhasil didaftarkan!', user: { id: newUser.id, username: newUser.username, role: newUser.role } });
    } catch (err) {
        // TAMPILKAN ERROR SEBENARNYA DI TERMINAL
        console.error("!!!! ERROR TERJADI DI ENDPOINT REGISTER !!!!"); // Tambah log ini
        console.error(err); // INI DIA YANG PENTING!

        res.status(500).json({ message: 'Terjadi kesalahan pada server' });
    }
});

// ... (kode untuk login dan activities tetap sama) ...
// 5. Buat Endpoint Login
app.post('/api/login', async (req, res) => {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username);
    if (!user) {
        return res.status(401).json({ message: 'Username atau password salah' });
    }
    const isMatch = await bcrypt.compare(password, user.password);
    if (!isMatch) {
        return res.status(401).json({ message: 'Username atau password salah' });
    }
    const token = jwt.sign(
        { id: user.id, username: user.username, role: user.role },
        process.env.JWT_SECRET,
        { expiresIn: '1h' }
    );
    res.json({ message: 'Login berhasil!', token });
});

// 6. Buat Endpoint untuk Melihat Semua Kegiatan
app.get('/api/activities', (req, res) => {
    res.json(activities);
});

// 7. Jalankan server
app.listen(PORT, () => {
    console.log(`Server berjalan di http://localhost:${PORT}`);
    console.log('PERINGATAN: Data disimpan di memori dan akan hilang saat server dimatikan!');
});