# 🧮 Kalkulator Titik Impas (BEP) dengan Metode Biseksi

[![Python](https://img.shields.io/badge/Python-3.6%2B-blue.svg)](https://www.python.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Stable-brightgreen.svg)](https://github.com/username/break-even-calculator)

Program Python untuk menghitung **Titik Impas (Break-Even Point)** menggunakan **Metode Biseksi** - alat analisis bisnis yang akurat dan terjamin konvergensinya.

## ✨ Fitur Unggulan

- 🎯 **Perhitungan Akurat** - Metode numerik biseksi untuk hasil presisi
- 📊 **Analisis Bisnis Lengkap** - Margin, revenue, cost analysis
- 🔄 **Konvergensi Terjamin** - Selalu menemukan solusi
- 💻 **User-Friendly** - Interface jelas dengan progress tracking
- 🛡️ **Error Handling** - Validasi input dan handling exception
- 💡 **Business Intelligence** - Rekomendasi strategis berdasarkan hasil

## 📋 Prasyarat

- **Python 3.6** atau lebih tinggi
- Tidak perlu install library tambahan (pure Python)

## 🚀 Instalasi & Menjalankan

### 1. Download Program
```bash
git clone https://github.com/username/break-even-calculator.git
cd break-even-calculator
```

### 2. Jalankan Program
```bash
python break_even_calculator.py
```

**Atau:**
```bash
python3 break_even_calculator.py
```

## 💡 Cara Menggunakan

### 🎪 Demo Cepat
Jalankan program tanpa modifikasi untuk melihat contoh:

```bash
python break_even_calculator.py
```

### 🛠 Customisasi dengan Data Bisnis Anda
Edit bagian **PARAMETER BISNIS** di file `break_even_calculator.py`:

```python
# PARAMETER BISNIS - EDIT BAGIAN INI
FIXED_COST = 50000000      # ⬅️ Ganti: Biaya tetap perusahaan
VARIABLE_COST = 150000     # ⬅️ Ganti: Biaya variabel per unit  
SELLING_PRICE = 300000     # ⬅️ Ganti: Harga jual per unit

# INTERVAL TEBAKAN
A = 0                      # ⬅️ Quantity minimum realistis
B = 500                    # ⬅️ Quantity maksimum realistis
```

### 📝 Contoh Konfigurasi Berbagai Bisnis

#### 🏪 Toko Retail
```python
FIXED_COST = 80000000      # Sewa, gaji, utilities
VARIABLE_COST = 120000     # Harga beli produk
SELLING_PRICE = 200000     # Harga jual produk
A = 0
B = 1500
```

#### ☕ Coffee Shop  
```python
FIXED_COST = 25000000      # Sewa, equipment, gaji
VARIABLE_COST = 8000       # Bahan baku per cup
SELLING_PRICE = 25000      # Harga jual per cup
A = 0
B = 3000
```

#### 💼 Jasa Konsultan
```python
FIXED_COST = 120000000     # Gaji, office, operational
VARIABLE_COST = 0          # Tidak ada biaya variabel
SELLING_PRICE = 25000000   # Fee per project
A = 0
B = 10
```

## 📊 Memahami Output

### Contoh Output:
```
============================================================
HASIL PERHITUNGAN TITIK IMPAS
============================================================
📍 Titik Impas (BEP): 333.33 unit
📍 Pembulatan praktis: 333 unit
💰 Total Pendapatan: Rp 99,999,900
💸 Total Biaya: Rp 99,999,500
📊 Profit pada solusi: Rp -0.40
🔄 Jumlah iterasi: 23
```

### 🔍 Penjelasan Output:
- **333 unit** harus dijual untuk menutup semua biaya
- **334 unit** mulai memberikan profit
- **Margin kontribusi** Rp 150,000 per unit
- **Konvergen** dalam 23 iterasi

## ⚠️ Troubleshooting

### ❌ Error: "Interval tidak valid"
**Penyebab:** f(a) dan f(b) sama-sama positif/negatif
**Solusi:** Perlebar interval
```python
A = 0
B = 1000    # ⬅️ Diperlebar
```

### ❌ Error: "Maximum iterasi tercapai"
**Penyebab:** Toleransi terlalu ketat
**Solusi:** Kurangi presisi
```python
tol=1e-3    # ⬅️ Dari 1e-6 menjadi 1e-3
```

### ❌ Program Terlalu Lama
**Solusi:** Batasi iterasi maksimal
```python
max_iter=50  # ⬅️ Batasi sampai 50 iterasi
```

## 🛠️ Penggunaan Lanjutan

### 🔧 Custom Tolerance & Iteration
```python
results = break_even_bisection(
    fixed_cost=FIXED_COST,
    variable_cost=VARIABLE_COST, 
    selling_price=SELLING_PRICE,
    a=A, b=B,
    tol=1e-8,        # ⬅️ Lebih presisi
    max_iter=200     # ⬅️ Iterasi lebih banyak
)
```

### 📈 Melacak Progress
Program menampilkan 5 iterasi terakhir untuk memantau konvergensi:

```
PROGRES KONVERGENSI (5 iterasi terakhir):
Iter | Quantity (c) |    Profit f(c)  | Lebar Interval
 19  |   333.007812 |    -298.828125  |       1.953125
 20  |   333.984375 |     147.460938  |       0.976562
```

## 🏗️ Struktur Kode

```
break_even_calculator.py
├── break_even_bisection()    # Algoritma utama
├── display_results()         # Format output  
├── analyze_business_implications()  # Analisis bisnis
└── Main Execution           # Entry point program
```

