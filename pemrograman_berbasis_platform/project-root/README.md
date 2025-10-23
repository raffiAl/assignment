# Sistem Pengolah Dokumen Multi-Format (Java Modular Project)

## 📌 Deskripsi
Proyek ini adalah implementasi studi kasus **Pemrograman Berbasis Platform** (Sesi 5) dengan topik **Modul dan Paket**.  
Tujuannya adalah membuat sistem sederhana yang dapat memproses dokumen dalam berbagai format menggunakan **Java Platform Module System (JPMS)**.  

Dengan pendekatan modular:
- **doc.core** → mendefinisikan kontrak (`DocumentProcessor`) dan model data (`Document`).
- **doc.txt** → menyediakan implementasi pemrosesan dokumen format **Plain Text**.
- **doc.app** → aplikasi utama yang memuat semua implementasi `DocumentProcessor` menggunakan `ServiceLoader`.

Struktur ini memungkinkan penambahan format baru (misalnya HTML, Markdown, PDF) tanpa perlu mengubah kode inti.

---


---

## ⚙️ Cara Kompilasi & Menjalankan

### 1. Kompilasi Semua Modul
Jalankan perintah berikut dari root proyek:
bash
javac -d out --module-source-path . $(find . -name "*.java")

### Menjalankan Aplikasi
java --module-path out -m doc.app/doc.app.MainApp

▶️ Contoh Output
Jika berhasil dijalankan, output yang muncul adalah:

Format tersedia: Plain Text
Plain Text Content: Ini contoh isi dokumen
