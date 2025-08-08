# Otel Rezervasyon Sistemi (Hakan Cem Gerçek 01.08.2025)

Java Spring Boot ile yazılmış, HTTP üzerinden JSON veri sunan, katmanlı yapıda bir back-end RESTful Web API uygulaması.
Spring Boot tabanlı bu proje, bir otel işletmesi için temel rezervasyon, müşteri ve oda yönetimi işlevlerini sağlamaktadır. Resepsiyonist ve yönetici (admin) rollerine göre yetkilendirilmiş kullanıcı erişimi sunar.

## Teknolojiler

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database (test için)
- Lombok
- Postman (API testleri)
- ModelMapper (DTO/Entity dönüşümleri)

## Katmanlar

- Entity: `Customer`, `Room`, `Reservation` gibi JPA Entity’leri.
- DTO: `CustomerDTO`, `RoomDTO`, `ReservationDTO` gibi veri taşıma sınıfları.
- Mapper: Entity ile DTO dönüşümleri.
- Controller: API uç noktaları (Admin ve Resepsiyonist için ayrı ayrı).
- Service: İş mantığı katmanı.
- Security: Spring Security ile role-based erişim.
- Exception Handling: Global hatalar için özelleştirilmiş yanıtlar.

## Özellikler

-  Müşteri CRUD işlemleri (resepsiyonist/admin rolleriyle)
-  Oda bilgilerini getirme (admin için daha detaylı)
-  Rezervasyon oluşturma
-  DTO kullanımı ve validasyon
-  Global exception handler
-  Yetki kontrolü (admin vs resepsiyonist)

## Roller ve Yetkiler

Resepsiyonist : Müşteri ve rezervasyon işlemleri yapabilir.
Admin : Tüm işlemleri görebilir, detaylı verilere erişebilir.

## Test

API uç noktaları Postman ile test edilmiştir. 

