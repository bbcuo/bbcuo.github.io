import drill.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        library lib = new library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== 📚 图书管理系统 ==========");
            System.out.println("1. 添加图书");
            System.out.println("2. 删除图书");
            System.out.println("3. 修改图书");
            System.out.println("4. 查询图书");
            System.out.println("5. 显示全部");
            System.out.println("6. 借阅图书");
            System.out.println("7. 归还图书");
            System.out.println("0. 退出系统");
            System.out.println("====================================");
            System.out.print("请输入操作编号：");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> lib.addBook();
                case 2 -> lib.deleteBook();
                case 3 -> lib.updateBook();
                case 4 -> lib.searchBook();
                case 5 -> lib.showAllBooks();
                case 6 -> lib.borrowBook();
                case 7 -> lib.returnBook();
                case 0 -> {
                    System.out.println("👋 感谢使用，再见！");
                    return;
                }
                default -> System.out.println("❌ 输入有误，请重新输入！");
            }
        }
    }
}