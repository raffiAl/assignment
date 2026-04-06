# README

## 1. Penjelasan maksud dari Class dan Object

- **Class** adalah cetak biru atau template untuk membuat objek. Class mendefinisikan atribut (data) dan method (fungsi) yang dimiliki oleh objek.
- **Object** adalah contoh nyata dari class. Object dibuat berdasarkan class dan berisi nilai nyata untuk atribut-atribut yang didefinisikan oleh class tersebut.

Contoh sederhana:
- Class `Komputer` menjelaskan apa saja sifat dan kemampuan sebuah komputer.
- Object `mykom` adalah sebuah komputer nyata yang dibuat dari class `Komputer`.

## 2. Jenis-jenis Method

1. **Instance method**
   - Method yang dipanggil melalui objek.
   - Bekerja pada data yang dimiliki oleh objek tersebut.
   - Contoh: `getJenis()`, `getMerk()`, `setDataKomputer(...)`.

2. **Static method**
   - Method yang bisa dipanggil langsung dari class tanpa membuat objek.
   - Biasanya digunakan untuk fungsi umum yang tidak tergantung pada data objek.
   - Contoh di Java: `public static void main(String[] args)`.

3. **Accessor method (getter)**
   - Method yang digunakan untuk membaca nilai atribut.
   - Contoh: `getJenis()` mengembalikan nilai `jenis_komputer`.

4. **Mutator method (setter)**
   - Method yang digunakan untuk mengubah nilai atribut.
   - Contoh: `setDataKomputer(String jenis, String merk)` mengisi nilai atribut `jenis_komputer` dan `merk`.

## 3. Penjelasan bagian pada gambar sesuai nomor

1. `public class Komputer {`
   - Ini adalah deklarasi class bernama `Komputer`.
   - Class ini menjadi cetak biru untuk objek komputer.

2. `String jenis_komputer;` dan `private String merk;`
   - Ini adalah atribut class.
   - `jenis_komputer` menyimpan tipe komputer, sedangkan `merk` menyimpan merek.
   - `private` berarti atribut `merk` hanya dapat diakses dari dalam class saja.

3. `public void setDataKomputer(String jenis, String merk){ ... }`
   - Ini adalah method setter.
   - Digunakan untuk memberikan nilai pada atribut `jenis_komputer` dan `merk`.
   - `this.merk = merk;` memastikan atribut class diisi dengan nilai parameter.

4. `public String getJenis(){ return jenis_komputer; }`
   - Ini adalah method getter untuk membaca nilai `jenis_komputer`.
   - Mengembalikan tipe data `String` yang berisi jenis komputer.

5. `public String getMerk(){ return merk; }`
   - Ini adalah method getter untuk membaca nilai `merk`.
   - Mengembalikan nilai merek komputer.

6. `Komputer mykom = new Komputer();`
   - Ini membuat objek baru dari class `Komputer` bernama `mykom`.
   - `new Komputer()` memanggil konstruktor default untuk membuat instance.

7. `mykom.setDataKomputer("LAPTOP", "MACBOOK");`
   - Ini memanggil method `setDataKomputer` pada objek `mykom`.
   - Atribut `jenis_komputer` diisi dengan `LAPTOP` dan `merk` diisi dengan `MACBOOK`.

8. `System.out.println(mykom.getJenis());` dan `System.out.println(mykom.getMerk());`
   - Ini mencetak nilai `jenis` dan `merk` dari objek `mykom`.
   - `getJenis()` dan `getMerk()` mengembalikan data yang telah diset sebelumnya.
