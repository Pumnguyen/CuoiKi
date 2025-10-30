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

## 3. Mục tiêu của hệ thống  

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
| Hệ điều hành              | Windows 11                           |

---



## 6. Hướng dẫn cài đặt và chạy dự án  

### **Bước 1: Cấu hình môi trường**  
- Cài đặt **JDK 17**  
- Cài đặt **Apache Tomcat 10.1**  
- Cài đặt **MySQL 8.0**  
- Cài đặt **Eclipse IDE for Enterprise Java Developers**

### **Bước 2: Import project**  
Trong Eclipse:  
`File → Import → Existing Maven Project → Chọn thư mục DAWEBB2/`

### **Bước 3: Cấu hình cơ sở dữ liệu**  
Tạo database MySQL:  
```sql
CREATE DATABASE uteshop;

```

## **7. Các chức năng chính**
 **Người dùng**
+ Đăng ký, đăng nhập tài khoản  
+ Xem chi tiết sản phẩm và danh mục  
+ Thêm sản phẩm vào giỏ hàng  
+ Thanh toán trực tuyến (VNPay - TryItNow sandbox)  
+ Đánh giá sản phẩm sau khi mua  

**Quản trị viên (Admin)**
+ Quản lý sản phẩm, danh mục, người dùng  
+ Xem, duyệt đơn hàng và doanh thu  
+ Trang **Analytics Dashboard** hiển thị thống kê bán hàng  

---

## **8. Mô hình cơ sở dữ liệu**

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

## **9. Kết quả đạt được**

Website hoạt động ổn định, tích hợp VNPay sandbox thành công  
Giao diện thân thiện, hiện đại  
Cấu trúc code theo mô hình MVC rõ ràng
Chức năng **CRUD** hoạt động đầy đủ  
Dễ mở rộng, có thể triển khai thật với môi trường production  

---

## **10. Giao diện**

```markdown
![Đăng nhập](<img width="980" height="371" alt="image" src="https://github.com/user-attachments/assets/42196602-0d33-45f5-ade5-b217dc4f9f81" />)
![Trang chủ](<img width="980" height="471" alt="image" src="https://github.com/user-attachments/assets/471472e7-7c38-4054-a3ff-038a3476c85c" />)
![Thông tin người dùng và Admin](<img width="980" height="469" alt="image" src="https://github.com/user-attachments/assets/5effb6bf-ad32-4c53-9c15-fed39ec7c80e" />)
![Quản lý đơn hàng dành cho Admin](<img width="980" height="470" alt="image" src="https://github.com/user-attachments/assets/4d9abb68-bf8c-4e14-883f-f9f3dc85e6ce" />)
![Danh mục sản phẩm](<img width="980" height="473" alt="image" src="https://github.com/user-attachments/assets/d655f23f-0304-46d2-a929-9a745b37d6c2" />)
![Thông tin sản phẩm](<img width="980" height="472" alt="image" src="https://github.com/user-attachments/assets/7e8a7689-4285-45f3-a5c4-cf94dec40371" />)
![Dashboard dành cho Admin](<img width="980" height="470" alt="image" src="https://github.com/user-attachments/assets/69473738-038a-4618-991d-470bbac2ba59" />)
![Thanh toán VNPay](<img width="980" height="467" alt="image" src="https://github.com/user-attachments/assets/3939a663-9a02-4236-97ad-3289451cdfe4" />)
![Sơ đồ ERD](<img width="980" height="746" alt="image" src="https://github.com/user-attachments/assets/93f8b612-fe41-4f8c-baa1-1080ccd6339b" />)
![Use Case Diagram](<img width="980" height="593" alt="image" src="https://github.com/user-attachments/assets/4d51be8f-35d6-4e10-b379-cf611a618b89" />)

