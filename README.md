# uts-struktur-data-narkotika-kelompok-28

# UTS Struktur Data - Putusan Narkotika

**Pembuat:** Govinda Abdurrasyid Altamis, kelompok 28
**Mata kuliah:** Struktur Data, Universitas Muhammadiyah Malang
**Dosen pengampu:** Galih W. Wicaksono

## Struktur data yang dipilih

**Struktur utama: Queue (antrean) generik, dibuat sendiri dari nol.**
Seluruh 50 objek Putusan disimpan di dalam Queue sebagai antrean pemeriksaan
putusan dengan prinsip FIFO (masuk pertama, keluar pertama). Queue dibangun dari
node berantai dengan penunjuk `front` dan `rear`, tanpa koleksi bawaan java.util.

**Struktur sekunder: Stack generik berbasis array** untuk menyimpan riwayat (audit)
operasi pengguna dengan prinsip LIFO.

### Pemetaan operasi ke kontrak umum
| Kontrak umum | Operasi Queue | Keterangan |
|---|---|---|
| add | enqueue | Menambah di belakang antrean |
| remove | dequeue | Mengambil dari depan antrean |
| get (peek) | peek | Melihat elemen depan tanpa mengambil |
| contains / cari | rotateSearch | Memutar antrean sambil mencari, lalu mengembalikan urutan (restore) |

### Perkiraan kompleksitas
| Operasi | Kompleksitas |
|---|---|
| enqueue, dequeue, peek | O(1) |
| rotateSearch, get(posisi), remove(posisi) | O(n) |

## Cara build dan test
- Build: `mvn compile`
- Test: `mvn test`

## Cara menjalankan
(Menyusul setelah aplikasi selesai.)