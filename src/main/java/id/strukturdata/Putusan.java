package id.strukturdata;
// Satu data putusan pengadilan (ringkasan terstruktur sesuai skema panduan 2.2).
import java.time.LocalDate;
import java.util.Objects;

// Identitas perkara
public class Putusan {
    private final String caseId;
    private final String nomorPerkara;
    private final String pengadilan;
    private final LocalDate tanggalPutusan;
    private final String terdakwaKode;
    private final String jenisNarkotika;
    private final double beratBarangBuktiGram;
    private final String pasalDakwaan;
    private final String pasalTerbukti;
    private final int tuntutanBulan;
    private final int vonisBulan;
    private final long dendaRupiah;
    // Ringkasan teks dan sumber
    private final String barangBukti;
    private final String keadaanMemberatkan;
    private final String keadaanMeringankan;
    private final String sourcePages;

    // Constructor: mengisi semua atribut saat objek dibuat.
    public Putusan(String caseId, String nomorPerkara, String pengadilan,
                   LocalDate tanggalPutusan, String terdakwaKode,
                   String jenisNarkotika, double beratBarangBuktiGram,
                   String pasalDakwaan, String pasalTerbukti,
                   int tuntutanBulan, int vonisBulan, long dendaRupiah,
                   String barangBukti, String keadaanMemberatkan,
                   String keadaanMeringankan, String sourcePages) {
        this.caseId = caseId;
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.terdakwaKode = terdakwaKode;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBuktiGram = beratBarangBuktiGram;
        this.pasalDakwaan = pasalDakwaan;
        this.pasalTerbukti = pasalTerbukti;
        this.tuntutanBulan = tuntutanBulan;
        this.vonisBulan = vonisBulan;
        this.dendaRupiah = dendaRupiah;
        this.barangBukti = barangBukti;
        this.keadaanMemberatkan = keadaanMemberatkan;
        this.keadaanMeringankan = keadaanMeringankan;
        this.sourcePages = sourcePages;
    }

    // Getter: untuk membaca nilai atribut dari luar class.
    public String getCaseId() { return caseId; }
    public String getNomorPerkara() { return nomorPerkara; }
    public String getPengadilan() { return pengadilan; }
    public LocalDate getTanggalPutusan() { return tanggalPutusan; }
    public String getTerdakwaKode() { return terdakwaKode; }
    public String getJenisNarkotika() { return jenisNarkotika; }
    public double getBeratBarangBuktiGram() { return beratBarangBuktiGram; }
    public String getPasalDakwaan() { return pasalDakwaan; }
    public String getPasalTerbukti() { return pasalTerbukti; }
    public int getTuntutanBulan() { return tuntutanBulan; }
    public int getVonisBulan() { return vonisBulan; }
    public long getDendaRupiah() { return dendaRupiah; }
    public String getBarangBukti() { return barangBukti; }
    public String getKeadaanMemberatkan() { return keadaanMemberatkan; }
    public String getKeadaanMeringankan() { return keadaanMeringankan; }
    public String getSourcePages() { return sourcePages; }

    // Ringkasan satu baris, dipakai untuk fitur Tampil.
    @Override
    public String toString() {
        return caseId + " | " + nomorPerkara + " | " + pengadilan
                + " | " + jenisNarkotika
                + " | vonis " + vonisBulan + " bulan";
    }

    // Dua Putusan dianggap sama kalau caseId-nya sama.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Putusan lain = (Putusan) o;
        return Objects.equals(caseId, lain.caseId);
    }

    // Harus konsisten dengan equals: dihitung dari caseId saja.
    @Override
    public int hashCode() {
        return Objects.hash(caseId);
    }

    // Mengembalikan pesan error, atau null kalau data valid.
    // Dipakai saat impor CSV untuk menolak record yang salah.
    // Atribut wajib: caseId, nomorPerkara, terdakwaKode.
    // Atribut lain boleh kosong (nilai tidak ditemukan ditulis kosong/0, bukan diperkirakan).
    public String validasi() {
        if (caseId == null || caseId.isBlank()) return "caseId kosong";
        if (nomorPerkara == null || nomorPerkara.isBlank()) return "nomorPerkara kosong";
        if (terdakwaKode == null || terdakwaKode.isBlank()) return "terdakwaKode kosong";
        if (tuntutanBulan < 0) return "tuntutanBulan tidak boleh negatif";
        if (vonisBulan < 0) return "vonisBulan tidak boleh negatif";
        if (dendaRupiah < 0) return "dendaRupiah tidak boleh negatif";
        if (beratBarangBuktiGram < 0 || Double.isNaN(beratBarangBuktiGram)) return "beratBarangBuktiGram tidak valid (negatif atau bukan angka)";
        return null;
    }
}