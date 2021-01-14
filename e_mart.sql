CREATE DATABASE E_SMART
GO
USE E_SMART
GO
drop database E_SMART
GO
--thong tin bang sinh vien--
CREATE TABLE tbl_SinhVien
(
	id int primary key identity,
	ma_sv varchar(50) not null unique,
	id_lop int not null,
	ho_ten nvarchar(200) not null,
	gioi_tinh tinyint default(1) not null, --1 la nam
	ngay_sinh date not null,
	ngay_nhap_hoc date not null,
	ngay_cap_nhat date not null,
	di_dong varchar(11) not null unique,
	dt_gia_dinh varchar(11) not null,
	email varchar(200) not null unique,
	dia_chi nvarchar(200) not null,
	avatar text ,
	username varchar(100) not null unique,
	password varchar(100) not null,
	ghi_chu nvarchar(200) ,
	trang_thai bit default(0) , -- mo/khoa tai khoan mac dinh 0 la dang cho xet duyet
)
GO
-- thong tin lop hoc--
CREATE TABLE tbl_LopHoc
(
	id int primary key identity,
	ten_lop varchar(10) not null unique,
	khoa_hoc varchar(100) not null,
	nien_khoa int not null , -- nam hoc
)
GO

--thong tin bang khieu nai--
CREATE TABLE tbl_KhieuNai
(
	id int primary key identity,
	id_SinhVien int not null,
	tieu_de nvarchar(100) not null,
	noi_dung nvarchar(200) not null,
	ngay_tao date not null,
	ngay_cap_nhat date not null,
)
GO
-- rang buoc sinh vien va lop hoc
ALTER TABLE tbl_SinhVien
ADD FOREIGN KEY (id_lop) REFERENCES tbl_LopHoc(id)
GO
--rang buoc khieu nai va sinh vien--
ALTER TABLE tbl_KhieuNai
ADD FOREIGN KEY (id_SinhVien) REFERENCES tbl_SinhVien(id)
GO
-- thong tin bang phan quyen --
CREATE TABLE tbl_PhanQuyen
(
	id_quyen int primary key identity,
	ma_quyen varchar(10) not null, -- ma quyen han
	mo_ta nvarchar(200) not null
)
GO
-- thong tin chi tiet phan quyen
CREATE TABLE tbl_PhanQuyenChiTiet
(
	id_quyen int not null,
	id_GiangVien int not null,
	ngay_cap_nhat date not null,
	ghi_chu nvarchar(200) not null
)
GO
-- thong tin bang giao vien
CREATE TABLE tbl_GiaoVien
(
	id int primary key identity,
	ma_gv varchar(10) not null unique,
	ho_ten nvarchar(100) not null,
	gioi_tinh tinyint default(1) not null,
	ngay_sinh date not null,
	dien_thoai varchar(11) not null unique,
	dia_chi nvarchar(200) not null,
	email varchar(100) not null unique,
	ngay_tao date not null,
	ngay_cap_nhat date not null,
	trang_thai bit default(1), -- 1 la tai khoan dang mo khoa
	username varchar(100) not null unique,
	password varchar(100) not null
)
GO
-- rang buoc phan quyen va giao vien
ALTER TABLE tbl_PhanQuyenChiTiet
ADD CONSTRAINT PK_PhanQuyen PRIMARY KEY (id_quyen,id_GiangVien);
GO
-- rang buoc khoa ngoai phan quyen va phan quyen chi tiet -- 
ALTER TABLE tbl_PhanQuyenChiTiet
ADD FOREIGN KEY (id_quyen) REFERENCES tbl_PhanQuyen(id_quyen);
GO
-- rang buoc phan quyen chi tiet va bang giao vien
ALTER TABLE tbl_PhanQuyenChiTiet
ADD FOREIGN KEY (id_GiangVien) REFERENCES tbl_GiaoVien(id);
GO
-- thong tin bang bo de
CREATE TABLE tbl_BoDe
(
	id int primary key identity,
	id_GiangVien int not null, -- nguoi ra de
	noi_dung nvarchar(200) not null,
	ngay_tao date not null,
	ngay_cap_nhat date not null,
	mo_ta nvarchar(200) not null,
	trang_thai bit default(0) -- 0 la trang thai bo de dang cho xet duyet 
)
GO
--thong tin bang ket qua bo de--
CREATE TABLE tbl_KetQua
(
	id_SinhVien int not null,
	id_BoDe int not null,
	ngay_thi date not null,
	tong_diem float not null
)
GO
-- rang buoc bo de va giao vien
ALTER TABLE tbl_BoDe
ADD FOREIGN KEY (id_GiangVien) REFERENCES tbl_GiaoVien(id);
GO
-- rang buoc ket qua voi sinh vien va ket qua voi bo de
-- hop khoa chinh tu  2 khoa ngoai
ALTER TABLE tbl_KetQua
ADD CONSTRAINT PK_KetQua PRIMARY KEY (id_SinhVien,id_BoDe);
GO
-- rang buoc bang ket qua va bo de
ALTER TABLE tbl_KetQua
ADD FOREIGN KEY (id_BoDe) REFERENCES tbl_BoDe(id);
GO
-- rang buoc bang ket qua va bang sinh vien
ALTER TABLE tbl_KetQua
ADD FOREIGN KEY (id_SinhVien) REFERENCES tbl_SinhVien(id);
GO
-- tao bang mon hoc
CREATE TABLE tbl_mon
(
	id int primary key identity,
	ten_mon nvarchar(100) not null,
	noi_dung nvarchar(200) not null,
	mo_ta nvarchar(200) not null,
	ngay_tao date not null,
	ngay_cap_nhat date not null,
	trang_thai bit default(1) -- mac dinh 1 la mon hoc dang duoc dung de thi
)
GO
-- bang hang cau(muc do kho de cua cau hoi trong bo de)
CREATE TABLE tbl_HangCau
(
	id int primary key identity,
	ma_hang varchar(10) not null,
	mo_ta nvarchar(100) not null,
	muc_diem float not null,
	ngay_tao date not null,
	ngay_cap_nhat date not null
)
GO
-- bang bo de chi tiet
CREATE TABLE tbl_BoDeChiTiet
(
	id_BoDe int not null,
	id_CauHoi int not null,
	diem float not null
)
GO
-- tao rang buoc cho bo de va cau hoi
-- hop khoa chinh cho bang bo de chi tiet
ALTER TABLE tbl_BoDeChiTiet
ADD CONSTRAINT PK_BoDeChiTiet PRIMARY KEY (id_BoDe,id_CauHoi);
GO
-- rang buoc bo de chi tiet va bo de
ALTER TABLE tbl_BoDeChiTiet
ADD FOREIGN KEY (id_BoDe) REFERENCES tbl_BoDe(id);
GO

-- tao bang cau hoi
CREATE TABLE tbl_CauHoi
(
	id	int identity primary key,
	id_mon int not null,
	id_hang int not null,
	loai_cau int not null, -- moi muc cau se ung voi 1 so nhat dinh
	noi_dung nvarchar(200) not null,
	ngay_tao date not null,
	ngay_cap_nhat date not null,
	ghi_chu nvarchar(200) not null,
	trang_thai bit default(1)
)
GO
--rang buoc bo de chi tiet va cau hoi
ALTER TABLE tbl_BoDeChiTiet
ADD FOREIGN KEY (id_CauHoi) REFERENCES tbl_CauHoi(id);
GO

-- tao bang dap an
CREATE TABLE tbl_DapAn
(
	id int primary key identity,
	id_cauhoi int not null,
	noi_dung nvarchar(200) not null,
	dap_an bit default(1) not null, -- dung/sai
)
GO
--rang buoc dap an va cau hoi
ALTER TABLE tbl_DapAn
ADD FOREIGN KEY (id_cauhoi) REFERENCES tbl_CauHoi(id);
GO
-- rang buoc bang cau hoi va hang cau
ALTER TABLE tbl_CauHoi
ADD FOREIGN KEY (id_hang) REFERENCES tbl_HangCau(id);
GO
-- rang buoc cau hoi va mon hoc
ALTER TABLE tbl_CauHoi
ADD FOREIGN KEY (id_mon) REFERENCES tbl_mon(id);
GO

--============================================Proc=================================
/*@id int,
 @ma_gv varchar(10),
 @ho_ten nvarchar(100),
 @gioi_tinh bit,
 @ngay_sinh date,
 @dien_thoai nvarchar(11),
 @dia_chi nvarchar(200),
 @email varchar(100),
 @ngay_tao date,
 @ngay_cap_nhat date,
 @trang_thai bit,
 @username varchar(100),
 @password varchar(100)*/
CREATE PROCEDURE tbl_GiaoVien

AS
	SELECT * FROM tbl_GiaoVien
GO;