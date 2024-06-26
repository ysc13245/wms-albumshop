package bangshop.music.controller;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    Scanner sc = new Scanner(System.in);
    OrderService orderService = new OrderService();


    public void order(int employeeNo) {
        System.out.println("========== 앨범 주문 메뉴 ==========");
        String albumNo = IOUtils.input("앨범 번호: ");
        int quantity = Integer.parseInt(IOUtils.input("수량: "));
        int result = orderService.order(albumNo, quantity, employeeNo);
        boolean result2 = orderService.insertStockOut(employeeNo);

        if (result > 0 && result2) {
            System.out.println("주문에 성공했습니다.\n");
        } else {
            System.out.println("주문 실패!");
        }
    }
}
