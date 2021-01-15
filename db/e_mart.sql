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
-- insert du lieu tbl_SinhVien
insert into tbl_SinhVien values 
('SV001',1,N'Thang',1,'1990-12-12','2020-10-10','2021-1-13','0987654321','0912345678','thang@gmail.com','Ha Noi',null,'thang','12345','khong co gi',1)

go

-- thong tin lop hoc--
CREATE TABLE tbl_LopHoc
(
	id int primary key identity,
	ten_lop varchar(10) not null unique,
	khoa_hoc varchar(100) not null,
	nien_khoa int not null , -- nam hoc
)
GO
-- insert du lieu tbl_LopHoc
insert into tbl_LopHoc values ('C1909i2','CNTT',2020)
go

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
-- INSERT DATA Tbl_GiaoVien
insert into tbl_GiaoVien values ('GV001',N'L� V�n T�',1,'1990-10-10','0123456789','H� Th�nh','te@gmail.com','2021-01-14','2021-01-14',1,'te','12345')
go
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

-- SELECT ALL
SELECT * FROM tbl_SinhVien
GO
SELECT * FROM tbl_LopHoc
GO
SELECT * FROM tbl_GiaoVien

go
-- CREATE PROCEDURE BY THANG

CREATE PROCEDURE getAllGV
AS
	SELECT * FROM tbl_GiaoVien
GO;

EXEC sp_HelpText '[dbo].[getAllGV]'
go
-- insert data bang giao vien
CREATE PROCEDURE insertGv
 @id int,
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
 @password varchar(100)
AS
 INSERT INTO tbl_GiaoVien VALUES (@ma_gv,@ho_ten,@gioi_tinh,@ngay_sinh,@dien_thoai,@dia_chi,@email,@ngay_tao,@ngay_cap_nhat,@trang_thai,@username,@password);
 GO;
 --update data giao vien

 CREATE PROCEDURE updateGiaoVien
 @id int,
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
 @password varchar(100)
 AS
	UPDATE tbl_GiaoVien SET ho_ten = @ho_ten, gioi_tinh = @gioi_tinh ,ngay_sinh = @ngay_sinh, dien_thoai = @dien_thoai, dia_chi = @dia_chi,
	email = @email , ngay_cap_nhat = @ngay_cap_nhat, trang_thai = @trang_thai , username = @username ,password = @password WHERE id = @id
GO
 -- xoa giao vien
  CREATE PROCEDURE deleteGiaoVien
  @id int
AS
	DELETE FROM tbl_GiaoVien WHERE id = @id
GO
--======= proc bo de ==========
-------insert bode----------
 CREATE PROCEDURE getAllBoDe
 AS
	SELECT * FROM tbl_BoDe
 GO
 -------insert bo de--------
  CREATE PROCEDURE insertBoDe
	@id_GiangVien int,
	@noi_dung nvarchar(200),
	@ngay_tao date,
	@ngay_cap_nhat date,
	@mo_ta nvarchar(200),
	@trang_thai bit
  AS
	INSERT INTO tbl_BoDe VALUES(@id_GiangVien,@noi_dung,@ngay_tao,@ngay_cap_nhat,@mo_ta,@trang_thai)
  GO
  -- getbyid bo de
CREATE PROCEDURE getByIdBoDe
@id int
AS
	SELECT * FROM tbl_BoDe WHERE id = @id
GO

  -----update bo de ------------
CREATE PROCEDURE updateBoDe
@id int,
@id_GiangVien int,
@noi_dung nvarchar(200),
@ngay_tao date,
@ngay_cap_nhat date,
@mo_ta nvarchar(200),
@trang_thai bit
AS
	UPDATE tbl_BoDe SET id_GiangVien = @id_GiangVien , noi_dung = @noi_dung ,ngay_cap_nhat = @ngay_cap_nhat, mo_ta = @mo_ta,trang_thai = @trang_thai WHERE id = @id
GO
-----delete bo de ----------
CREATE PROCEDURE deleteBoDe
@id int
AS 
	DELETE FROM tbl_BoDe WHERE id = @id
GO
--======================ket qua ================
-- select bang ket qua
CREATE PROCEDURE getAllKetQua
AS
	SELECT * FROM tbl_KetQua
GO
-- insert bang ket qua
CREATE PROCEDURE insertKetQua
@id_SinhVien int,
@id_BoDe int,
@ngay_thi date,
@tong_diem float
AS
	INSERT INTO tbl_KetQua VALUES (@id_SinhVien,@id_BoDe,@ngay_thi,@tong_diem)
GO
-- update bang ket qua
CREATE PROCEDURE updateKetQua
@id_SinhVien int,
@id_BoDe int,
@ngay_thi date,
@tong_diem float
AS
	UPDATE tbl_KetQua SET tong_diem = @tong_diem WHERE id_SinhVien = @id_SinhVien AND id_BoDe = @id_BoDe
GO
/*====================Proc bo de chi tiet=====================*/
-- lay du lieu bo de chi tiet
CREATE PROCEDURE getAllBoDeChiTiet
AS
	SELECT * FROM tbl_BoDeChiTiet
GO
-- insert 
CREATE PROCEDURE insertBoDeChiTiet
@id_de int,
@id_cau_hoi int,
@diem float
AS
	INSERT INTO tbl_BoDeChiTiet VALUES (@id_de,@id_cau_hoi,@diem)
GO
--update 
CREATE PROCEDURE updateBoDeChiTiet
@id_BoDe int,
@id_CauHoi int,
@diem float
AS
	UPDATE tbl_BoDeChiTiet SET diem = @diem WHERE id_BoDe = @id_BoDe AND id_CauHoi = @id_CauHoi
GO
--delete 
CREATE PROCEDURE deleteBoDeChiTiet
@id_BoDe int,
@id_CauHoi int
AS
	DELETE FROM tbl_BoDeChiTiet WHERE id_BoDe = @id_BoDe AND id_CauHoi = @id_CauHoi
GO
/*==============PROC CAU HOI================*/
--get tat ca du lieu bang cau hoi
CREATE PROCEDURE getAllCauHoi
AS
	SELECT * FROM tbl_CauHoi
GO
-- insert du lieu vao bang cau hoi
CREATE PROCEDURE insertCauHoi
@id_mon int,
@id_hang int,
@loai_cau int,
@noi_dung nvarchar(200),
@ngay_tao date,
@ngay_cap_nhat date,
@ghi_chu nvarchar(200),
@trang_thai bit
AS
	INSERT INTO tbl_CauHoi VALUES(@id_mon,@id_hang,@loai_cau,@noi_dung,@ngay_tao,@ngay_cap_nhat,@ghi_chu,@trang_thai)
GO
--update du lieu bang cau hoi
CREATE PROCEDURE updateCauHoi
@id int,
@id_mon int,
@id_hang int,
@loai_cau int,
@noi_dung nvarchar(200),
@ngay_tao date,
@ngay_cap_nhat date,
@ghi_chu nvarchar(200),
@trang_thai bit
AS
	UPDATE tbl_CauHoi SET id_mon = @id_mon, id_hang = @id_hang, loai_cau = @loai_cau,noi_dung = @noi_dung , ngay_cap_nhat = @ngay_cap_nhat,ghi_chu = @ghi_chu,trang_thai = @trang_thai WHERE id = @id
GO
-- delte record bang cau hoi
CREATE PROCEDURE deleteCauHoi
@id int
AS
	DELETE FROM tbl_CauHoi WHERE id = @id
GO
-- selete data theo id
CREATE PROCEDURE getByIdCauHoi
@id int
AS
	SELECT * FROM tbl_CauHoi WHERE id = @id
GO
/*==============PROC CAU HOI================*/