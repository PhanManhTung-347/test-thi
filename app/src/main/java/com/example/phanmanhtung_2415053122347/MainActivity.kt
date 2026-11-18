package com.example.phanmanhtung_2415053122347

import android.os.Binder
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.phanmanhtung_2415053122347.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var luotCuoi_2347: LuotNhan?= null
    private var soThuTu_2347=0
    private var phieuNhan_2347 = PhieuNhan()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtTong.text = "Tong: ${phieuNhan_2347.daNhan_2347}"
        binding.txtConLai.text = "Con lai: ${9- phieuNhan_2347.daNhan_2347}"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnGhiNhan.setOnClickListener {
            ghiNhan_2347()
        }
        binding.btnXoa.setOnClickListener {
            xoa_2347()
        }

    }
    fun ghiNhan_2347(){
        val ten=binding.edtTen.text.toString().chuanHoaTen_2347()
        val soLuong = binding.edtSoLuong.text.toString().trim().toIntOrNull()
        val tenHopLe = ten.length in 2..40
        val luongHopLe = soLuong!= null && soLuong in 1..9
         binding.edtTen.error = if (tenHopLe) null else "Ten phai co 2-40 ky tu"
        binding.edtSoLuong.error = if (luongHopLe) null else "Nhap so nguyen tu 1-9"
        luotCuoi_2347 = null
        binding.txtKetQua.text =""
        binding.txtMaLuot.text = ""
        if (!tenHopLe || soLuong == null|| !luongHopLe) return
        val tongMoi = phieuNhan_2347.daNhan_2347 +soLuong
        if (tongMoi >9){
            binding.edtSoLuong.error ="Chi con ${9-phieuNhan_2347.daNhan_2347} cho"
            return
        }
        soThuTu_2347++
        luotCuoi_2347 = LuotNhan(maLuot_2347 = QuyTacPhieu_2347.taoMaPhieu(soThuTu_2347), hoTen_2347 = ten, soLuong_2347 = soLuong)
        phieuNhan_2347= PhieuNhan(daNhan_2347 = tongMoi)
        val luot = luotCuoi_2347?: return
        binding.txtKetQua.text = "Xin chao ${luot.hoTen_2347}, so luong:${luot.soLuong_2347}"
        binding.txtMaLuot.text = luot.maLuot_2347
        binding.txtTong.text = "Tong: ${phieuNhan_2347.daNhan_2347}"
        binding.txtConLai.text = "Con lai: ${9- phieuNhan_2347.daNhan_2347}"
    }
    fun xoa_2347(){
        with(binding){
            edtTen.text.clear()
            edtSoLuong.text.clear()
            edtTen.error = null
            edtSoLuong.error = null
            txtKetQua.text =""
            txtMaLuot.text=""
            luotCuoi_2347 = null
        }
    }
}