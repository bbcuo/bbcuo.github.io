package drill;

import java.util.ArrayList;
import java.util.Scanner;

public class library {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addBook() {
        System.out.println("\n===== 添加图书 =====");
        System.out.print("请输入书名：");
        String title = sc.nextLine();
        System.out.print("请输入作者：");
        String author = sc.nextLine();
        System.out.print("请输入价格：");
        double price = sc.nextDouble();
        sc.nextLine();

        books.add(new Book(title, author, price));
        System.out.println("✅ 添加成功！");
    }

    public void deleteBook() {
        System.out.println("\n===== 删除图书 =====");
        System.out.print("请输入要删除的书名：");
        String title = sc.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                System.out.println("✅ 删除成功！");
                return;
            }
        }
        System.out.println("❌ 未找到该书！");
    }

    public void updateBook() {
        System.out.println("\n===== 修改图书 =====");
        System.out.print("请输入要修改的书名：");
        String title = sc.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.print("请输入新书名（回车跳过）：");
                String newTitle = sc.nextLine();
                if (!newTitle.isEmpty()) {
                    book.setTitle(newTitle);
                }

                System.out.print("请输入新作者（回车跳过）：");
                String newAuthor = sc.nextLine();
                if (!newAuthor.isEmpty()) {
                    book.setAuthor(newAuthor);
                }

                System.out.print("请输入新价格（回车跳过）：");
                String priceStr = sc.nextLine();
                if (!priceStr.isEmpty()) {
                    book.setPrice(Double.parseDouble(priceStr));
                }

                System.out.println("✅ 修改成功！");
                return;
            }
        }
        System.out.println("❌ 未找到该书！");
    }

    public void searchBook() {
        System.out.println("\n===== 查询图书 =====");
        System.out.print("请输入书名关键词：");
        String keyword = sc.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ 未找到匹配的图书！");
        }
    }

    public void showAllBooks() {
        System.out.println("\n===== 全部图书 =====");
        if (books.isEmpty()) {
            System.out.println("📭 书库为空，快去添加图书吧！");
            return;
        }
        System.out.println("共 " + books.size() + " 本：");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void borrowBook() {
        System.out.println("\n===== 借阅图书 =====");
        System.out.print("请输入要借阅的书名：");
        String title = sc.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isBorrowed()) {
                    System.out.println("❌ 该书已被借出！");
                } else {
                    book.setBorrowed(true);
                    System.out.println("✅ 借阅成功！请按时归还。");
                }
                return;
            }
        }
        System.out.println("❌ 未找到该书！");
    }

    public void returnBook() {
        System.out.println("\n===== 归还图书 =====");
        System.out.print("请输入要归还的书名：");
        String title = sc.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("✅ 归还成功！");
                } else {
                    System.out.println("❌ 该书未被借出！");
                }
                return;
            }
        }
        System.out.println("❌ 未找到该书！");
    }
}
