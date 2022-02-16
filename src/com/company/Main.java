package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLiDanhBa quanLiDanhBa = new QuanLiDanhBa();
        int luaChon = -1;
        do {
            menu();
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1: {
                    hienThiThongTinDanhBa(quanLiDanhBa);
                    break;
                }
                case 2: {
                    themMoiVaoDanhBa(quanLiDanhBa);

                    break;
                }
                case 3: {
                    chinhSuaDanhBa(quanLiDanhBa);
                    break;
                }
                case 4: {
                    xoaDanhBa(quanLiDanhBa);
                    break;
                }
                case 5: {
                    timKiem(quanLiDanhBa);
                    break;
                }
                case 6: {
                    ghiFli(quanLiDanhBa);
                    break;

                }
                case 7: {
                    docFile(quanLiDanhBa);
                    break;
                }
            }
        } while (luaChon != 0);
    }

    private static void ghiFli(QuanLiDanhBa quanLiDanhBa) {
        try {
            quanLiDanhBa.writeFile("danhba.txt");
        } catch (IOException e) {
        }
        System.out.println("ghi thành công");
    }

    private static void docFile(QuanLiDanhBa quanLiDanhBa) {
        File file = new File("danhba.txt");
        if (file.exists()) {

            try {
                quanLiDanhBa.readFile("danhba.txt");
                System.out.println("đọc thành công");
            } catch (IOException | ClassNotFoundException e) {
            }
        } else {
            System.err.println("file không tồn tại");
        }
    }


    private static void timKiem(QuanLiDanhBa quanLiDanhBa) {
        System.out.println("tìm theo số điện thoại");
        System.out.println("mời nhập số điện thoại cần tìm");
        int sdt = scanner.nextInt();
        int viTri = quanLiDanhBa.timViTriTheoSoDienThoai(sdt);
        if (viTri != -1) {
            System.err.println("thông tin theo số điện thoại: " + sdt + " là: ");
            quanLiDanhBa.timKiemTheoSdt(viTri);
        } else {
            System.err.println("không tìm thấy số điện thoại này trong Danh Bạ");
        }
    }

    private static void xoaDanhBa(QuanLiDanhBa quanLiDanhBa) {
        System.out.println("xóa danh bạ theo số điện thoại");
        System.out.println("mời nhập số điện thoại cần xóa");
        int sdt = scanner.nextInt();
        boolean kiemTra = quanLiDanhBa.xoaDanhBaTheoSdt(sdt);
        if (kiemTra) {
            System.out.println("xóa thành công");
        } else {
            System.err.println("xóa lỗi do không có sdt này trong danh bạ");
        }
    }

    private static void chinhSuaDanhBa(QuanLiDanhBa quanLiDanhBa) {
        System.out.println("chỉnh sửa theo theo số điện thoại");
        System.out.println("mời nhập số điện thoại");
        int sdt = scanner.nextInt();
        int viTri = quanLiDanhBa.timViTriTheoSoDienThoai(sdt);
        if (viTri != -1) {
            DanhBa danhBa = getDanhBa();
            quanLiDanhBa.chinhSuaDanhBaTheoSdt(viTri, danhBa);
            System.out.println("chỉnh sửa thành công");

        } else {
            System.err.println("không tìm thấy số điện thoại này trong danh bạ");
        }
    }

    private static void themMoiVaoDanhBa(QuanLiDanhBa quanLiDanhBa) {
        System.out.println("thêm mới vào danh bạ");
        DanhBa danhBa = getDanhBa();
        quanLiDanhBa.themVaoDanhBa(danhBa);
        System.out.println("thêm thành cống");
    }

    private static void hienThiThongTinDanhBa(QuanLiDanhBa quanLiDanhBa) {
        int kiemTraDanhBa = quanLiDanhBa.checkSize();
        if (kiemTraDanhBa == 0) {
            System.err.println("danh bạ rỗng");
        } else {
            System.out.println("hiển thị danh bạ");
            quanLiDanhBa.hienThiDanhBa();
        }
    }

    private static void menu() {
        System.out.println("-----MENU-----");
        System.out.println("1. XEM DANH SÁCH");
        System.out.println("2. THÊM MỚI");
        System.out.println("3. CẬP NHẬT");
        System.out.println("4. XÓA");
        System.out.println("5. TÌM KIẾM");
        System.out.println("6. GHI VÀO FILE");
        System.out.println("7. ĐỌC FILE");
        System.out.println("0. THOÁT");
    }

    private static DanhBa getDanhBa() {
        System.out.println("mời nhập họ tên");
        scanner.nextLine();
        String hoTen = scanner.nextLine();
        System.out.println("mời nhập số điện thoại");
        int sdt = scanner.nextInt();
        System.out.println("mời nhập địa chỉ");
        scanner.nextLine();
        String dc = scanner.nextLine();
        System.out.println("mời nhập email");
        String email = scanner.nextLine();
        System.out.println("mời nhập facebook");
        String fb = scanner.nextLine();
        DanhBa danhBa = new DanhBa(hoTen, sdt, dc, email, fb);
        return danhBa;
    }
}
