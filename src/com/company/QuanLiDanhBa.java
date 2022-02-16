package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLiDanhBa {
    private List<DanhBa> danhBas = new ArrayList<>();

    public int checkSize() {
        return danhBas.size();
    }

    public int timViTriTheoSoDienThoai(int sdt) {
        int index = -1;
        for (int i = 0; i < danhBas.size(); i++) {
            if (danhBas.get(i).getSoDienThoai() == sdt) {
                index = i;
            }
        }
        return index;
    }


    //1 hiển thị danh bạ
    public void hienThiDanhBa() {
        for (int i = 0; i < danhBas.size(); i++) {
            System.out.println(danhBas.get(i));
        }
    }

    //2. thêm vào danh bạ
    public void themVaoDanhBa(DanhBa danhBa) {
        danhBas.add(danhBa);
    }

    //3. chỉnh sửa danh bạ
    public void chinhSuaDanhBaTheoSdt(int index, DanhBa danhBa) {
        danhBas.set(index, danhBa);
    }

    //4. xóa danh bạ
    public boolean xoaDanhBaTheoSdt(int sdt) {
        int viTriMuonXoa = timViTriTheoSoDienThoai(sdt);
        if (viTriMuonXoa != -1) {
            danhBas.remove(viTriMuonXoa);
            return true;
        }
        return false;
    }

    //5 tìm kiếm// tìm kiếm theo số điện thoại
    public int timKiemTheoSdt(int sdt) {
        bubbleSortSdt();
        int low = 0;
        int high = danhBas.size() - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (danhBas.get(mid).getSoDienThoai() == sdt) {
                return mid;
            } else if (danhBas.get(mid).getSoDienThoai() > danhBas.get(mid).getSoDienThoai()) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // sắp xếp nổi bọt theo số điện thoại
    public void bubbleSortSdt() {
        for (int i = 0; i < danhBas.size(); i++) {
            for (int j = danhBas.size() - 1; j > i; j--) {
                if (danhBas.get(j).getSoDienThoai() < danhBas.get(j - 1).getSoDienThoai()) {
                    DanhBa temp = danhBas.get(j);
                    danhBas.set(j, danhBas.get(j - 1));
                    danhBas.set(j - 1, temp);
                }
            }
        }
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        danhBas = (List<DanhBa>) ois.readObject();
        is.close();
        ois.close();
    }

    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(danhBas);
        os.close();
        oos.close();
    }
}

