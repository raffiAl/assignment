# Metode Numerik Modular Python

Package kecil berisi solusi contoh untuk beberapa persoalan metode numerik.

Instalasi
1. Pastikan Python 3.8+ terpasang
2. bikin venv: python -m venv .venv
3. aktifkan venv: source .venv/bin/activate
4. upgrade pip: python -m pip install --upgrade pip
5. pasang pkg editable: pip install -e .
4. instal matplotlib: pip install matplotlib

## Kode CLI untuk test setiap program, penggunaan tinggal salin code ke terminal

1. Luas persegi: panjang = 12.345 cm (5 AP), lebar = 0.034 m (2 AP)
- code: python cli.py area --length 12.345 --lunit cm --width 0.034 --wunit m --sfl 5 --sfw 2

2. Maclaurin e^x (orde 3) untuk x = 0.2
- code: python cli.py maclaurin 0.2

3. Galat relatif (aproksimasi 97, galat 3%)
- code: python cli.py error --approx 97 --rel 3

4. Metode tabel (fungsi default x*3 - 4x + 1) dan simpan plot
- code: python cli.py table --start -2 --end 2 --step 0.5 --plot --out table.png

5. Metode titik tetap (default g(x) = (1-x)**(1/3)), simpan plot
- code: python cli.py fixed-point --x0 0.5 --plot --out conv.png

6. linear
- code: python cli.py linear --matrix "[[4,-1,1],[1,3,-1],[1,-1,5]]"


Catatan
- Fungsi significant_figures_area menerima argument jumlah angka penting untuk setiap input agar deterministik.
- Untuk metode titik tetap cek syarat konvergensi sebelum memakai g lain.
