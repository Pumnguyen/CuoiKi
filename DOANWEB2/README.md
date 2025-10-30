## XÂY DỰNG WEBSITE BÁN MÔ HÌNH GUNDAM UTESHOP

---

## 1. Thông tin sinh viên  
**Họ và tên:** Nguyễn Lê Quang Trường  
**MSSV:** 22110258  
**Lớp:** 22110CLIS1  

---

## 2. Giới thiệu đề tài  

Đề tài **“Xây dựng Website Bán Mô Hình Gundam UTESHOP”** được thực hiện nhằm mô phỏng một hệ thống thương mại điện tử quy mô nhỏ, cho phép người dùng thực hiện các thao tác cơ bản của một website bán hàng như:  
- Xem sản phẩm  
- Đăng ký / đăng nhập tài khoản  
- Thêm sản phẩm vào giỏ hàng  
- Đặt hàng và thanh toán trực tuyến VNPay (TryItNow)

Phía **quản trị viên (admin)** có thể quản lý danh mục sản phẩm, thông tin người dùng, kiểm tra đơn hàng và theo dõi thống kê doanh thu.  
Mục tiêu là xây dựng một website hoàn chỉnh, có tính thực tế cao, giúp sinh viên thực hành và ứng dụng kỹ năng lập trình web với Java.

---

## 🎯 3. Mục tiêu của hệ thống  

- Xây dựng website thương mại điện tử hoạt động ổn định, thân thiện với người dùng.  
- Áp dụng công nghệ **Java Servlet, JSP, Hibernate, JDBC**.  
- Tích hợp thanh toán trực tuyến **VNPay** (môi trường TryItNow).  
- Xây dựng xác thực và phân quyền người dùng bằng **JWT**.  
- Cung cấp giao diện quản trị (Admin Dashboard) với chức năng **CRUD**.

---

## 4. Công nghệ và công cụ sử dụng  

| Thành phần                | Công nghệ sử dụng                     |
|---------------------------|--------------------------------------|
| Ngôn ngữ lập trình        | Java (JDK 17)                        |
| Framework                 | Servlet, JSP, Hibernate              |
| Giao diện (Frontend)      | HTML5, CSS3, Bootstrap 5, JSTL       |
| Cơ sở dữ liệu             | MySQL 8.0                            |
| Máy chủ ứng dụng          | Apache Tomcat 10.1                   |
| Thư viện hỗ trợ           | JWT, VNPay API, Sitemesh Decorator   |
| IDE phát triển            | Eclipse                              |
| Hệ điều hành              | Windows 10                           |

---

## 5. Cấu trúc dự án
```**
DAWEBB/
│
├── src/
│ └── main/
│ └── java/
│ └── me/
│ └── quangtruong/
│ ├── controller/
│ │ ├── HomeController.java
│ │ ├── ProductManagerController.java
│ │ └── VNPAYController.java
│ │
│ ├── entity/
│ │ ├── Product.java
│ │ ├── ProductCategory.java
│ │ ├── Users.java
│ │ ├── Orders.java
│ │ ├── Transaction.java
│ │ └── Rating.java
│ │
│ ├── dao/
│ └── jwt/
│
├── webapp/
│ ├── views/
│ │ ├── home.jsp
│ │ ├── shop.jsp
│ │ └── admin/
│ │ ├── dashboard.jsp
│ │ └── analytics.jsp
│ │
│ ├── assets/
│ │ ├── css/
│ │ ├── js/
│ │ └── images/
│ │
│ └── WEB-INF/
│ ├── web.xml
│ └── sitemesh.xml
│
├── pom.xml
└── README.md
```**
---

## 6. Hướng dẫn cài đặt và chạy dự án  

### **Bước 1: Cấu hình môi trường**  
- Cài đặt **JDK 17**  
- Cài đặt **Apache Tomcat 10.1**  
- Cài đặt **MySQL 8.0**  
- Cài đặt **Eclipse IDE for Enterprise Java Developers**

### **Bước 2: Import project**  
Trong Eclipse:  
`File → Import → Existing Maven Project → Chọn thư mục DAWEBB/`

### **Bước 3: Cấu hình cơ sở dữ liệu**  
Tạo database MySQL:  
```sql
CREATE DATABASE uteshop;
### **Bước 4: Cấu hình VNPay (TryItNow sandbox)**
vnp_TmnCode=UTESHOPTEST
vnp_HashSecret=UTESHOP_SECRET_123
vnp_Url=https://sandbox.vnpayment.vn/tryitnow/Home/CreateOrder
vnp_Returnurl=http://localhost:8080/DAWEBB/vnpay_return

---

### **Bước 5: Khởi chạy ứng dụng**
Add server Tomcat v10.1
Run project → Run on Server
Mở trình duyệt và truy cập:
http://localhost:8080/DAWEBB/home
## **5. Khởi chạy ứng dụng**

- Add server **Tomcat v10.1**  
- Run project → **Run on Server**  
- Mở trình duyệt và truy cập:  
  [http://localhost:8080/DAWEBB/home](http://localhost:8080/DAWEBB/home)

---

## ** 7. Các chức năng chính**

### ** Người dùng**
- Đăng ký, đăng nhập tài khoản  
- Xem chi tiết sản phẩm và danh mục  
- Thêm sản phẩm vào giỏ hàng  
- Thanh toán trực tuyến (**VNPay - TryItNow sandbox**)  
- Đánh giá sản phẩm sau khi mua  

### ** Quản trị viên (Admin)**
- Quản lý sản phẩm, danh mục, người dùng  
- Xem, duyệt đơn hàng và doanh thu  
- Trang **Analytics Dashboard** hiển thị thống kê bán hàng  

---

## ** 8. Mô hình cơ sở dữ liệu**

**Các bảng chính:**
- `Users(UserId, UserFullName, UserPhone, UserEmail, UserAddress, UserPassword, UserIsAdmin, UserImage, UserRegisDay)`
- `Product(ProductId, ProductName, ProductImage, ProductPrice, ProductAmount, ProductCategoryId)`
- `ProductCategory(ProductCategoryId, ProductCategoryName)`
- `Orders(OrderId, OrderPrice, OrderCount, OrderStatus, UserId, ProductId)`
- `Transaction(TransId, TransDay, TransAddress, TransStatus, TransTotalValue, UserId)`
- `Rating(RatingId, RatingDate, RatingValue, RatingComment, ProductId, UserId)`

**Các mối quan hệ:**
- `Users → Orders`: 1 - N  
- `ProductCategory → Product`: 1 - N  
- `Product → Rating`: 1 - N  
- `Users → Transaction`: 1 - N  

---

## ** 9. Kết quả đạt được**

- Website hoạt động ổn định, tích hợp **VNPay sandbox** thành công  
- Giao diện thân thiện, hiện đại  
- Cấu trúc code theo mô hình **MVC rõ ràng**  
- Chức năng **CRUD** hoạt động đầy đủ  
- Dễ mở rộng, có thể triển khai thật với môi trường production  

---

## ** 10. Hình minh họa**

> *(Thêm hình minh họa khi upload lên GitHub, ví dụ:)*

```markdown
![Trang chủ](./screenshots/home.png)
![Trang quản trị](./screenshots/admin_dashboard.png)
![Sơ đồ ERD](./docs/ERD.png)
![Use Case Diagram](./docs/usecase.png)

