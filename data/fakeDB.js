// data/fakeDb.js (Versi Sederhana)

// Ini adalah "database" kita, sebenarnya hanya array di memori.
// Kita menambahkan satu data contoh agar endpoint GET /activities langsung ada isinya.
let activities = [
    {
        id: 1,
        name: "Workshop Web Development",
        description: "Belajar dasar-dasar membuat website dengan HTML, CSS, dan JavaScript.",
        activity_date: "2024-02-15"
    },
    {
        id: 2,
        name: "Seminar AI",
        description: "Pembahasan tren terbaru dalam kecerdasan buatan.",
        activity_date: "2024-03-10"
    }
];

// Export variabel activities
module.exports = {
    activities
};