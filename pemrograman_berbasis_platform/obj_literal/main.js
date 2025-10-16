// 1 & 2. Membuat objek film "Interstellar" dengan Object Literal
const film = {
  judul: "Interstellar",
  tahunRilis: 2014,
  sutradara: "Christopher Nolan",
  genre: ["Sci-Fi", "Adventure", "Drama"],

  // 3. Menambahkan method tampilkanDetail
  tampilkanDetail() {
    return `Judul: ${this.judul}\nTahun Rilis: ${this.tahunRilis}\nSutradara: ${this.sutradara}\nGenre: ${this.genre.join(", ")}`;
  }
};

// 4. Akses dan tampilkan data menggunakan console.log
console.log(film.sutradara);                // Christopher Nolan
console.log(film.genre[1]);                 // Adventure
console.log(film.tampilkanDetail());