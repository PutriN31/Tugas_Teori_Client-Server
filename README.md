# Tugas_Teori_Client-Server
putri
Membuat Application Context

Selanjutnya, setelah membuat Class Configuration, kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Application Context
[https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html]
Kode : Membuat Application Context
 

Singleton
Singleton adalah salah satu Design Patterns untuk pembuatan objek, dimana sebuah object hanya dibuat satu kali saja
Dan ketika kita membutuhkan object tersebut, kita hanya akan menggunakan object yang sama * [https://refactoring.guru/design-patterns/singleto] Membuat Singleton di Java
Ada banyak cara membuat singleton object di Java
Cara yang paling sering digunakan adalah membuat class yang berisikan static method untuk membuat object dirinya sendiri
Selanjutnya constructor nya dibuat private, agar tidak bisa diakses dari luar
Sehingga user terpaksa menggunakan method static tersebut ketika ingin membuat object nya
Kode : Singleton Class
 

Bean
Saat sebuah object kita masukkan kedalam Spring Container IoC, maka kita sebut object tersebut adalah Bean
Secara default, bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama. Kita juga bisa mengubahnya jika tidak ingin singleton, nanti akan kita bahas di materi tersendiri Membuat Bean
Untuk membuat bean, kita bisa membuat sebuah method di dalam class Configuration
Selanjutnya nama method tersebut akan menjadi nama bean nya, dan return object nya menjadi object bean nya
Method tersebut perlu kita tambahkan annotation @Bean, untuk menandakan bahwa itu adalah bean
Secara otomatis Spring akan mengeksekusi method tersebut, dan return value nya akan dijadikan object bean secara otomatis, dan disimpan di container IoC
Kode : Membuat Bean
Mengakses Bean
Setelah kita membuat bean, secara otomatis semua object akan di-manage oleh Application Context
Untuk mengakses bean, kita bisa menggunakan method getBean milik Application Context
Kode : Mengakses Bean
 

Duplicate Bean
Di Spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama

Namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kita harus menggunakan nama bean yang berbeda

Selain itu, saat kita mengakses bean nya, kita wajib menyebutkan nama bean nya, karena jika tidak, Spring akan bingung harus mengakses bean yang mana

Kode : Duplicate Bean

Kode : Mengakses Duplicate Bean

 

Primary Bean
Jika terjadi duplicate bean, selain kita sebSecarautkan nama bean nya ketika ingin mengakses bean nya, kita juga bisa pilih salah satu bean menjadi primary

Dengan memilih salah satunya menjadi primary, secara otomatis jika kita mengakses bean tanpa menyebutkan nama bean nya, secara otomatis primary nya yang akan dipilih

Untuk memilih primary bean, kita bisa tambahkan annotaiton @Primary

Kode : Primary Bean

Kode : Mengakses Primary Bean

 

Mengubah Nama Bean
Secara default, nama bean diambil dari nama method

Namun kadang-kadang kita tidak ingin menggunakan nama method untuk nama bean

Saat project kita sudah besar, kadang bisa jadi nama method sama, walaupun isi bean nya berbeda, dan di Spring, nama bean itu unik, tidak boleh sama

Jika kita ingin mengubah nama bean, kita bisa menggunakan method value() milik annotation @Bean

Kode : Mengubah Nama Bean

Kode : Mengakses Bean

 

Dependency Injection
Saat kita membuat object, sudah pasti kita sering membuat object yang tergantung dengan object lain
Dependency Injection (DI) adalah teknik dimana kita bisa mengotomatisasi proses pembuatan object yang tergantung dengan object lain, atau kita sebut dependencies
Dependencies akan secara otomatis di-inject (dimasukkan) kedalam object yang membutuhkannya
Spring Framework sejak awal dibilang sebuah framework IoC yang memang cara kerjanya menggunakan
Tanpa Dependency Injection
Sebenarnya tanpa Dependency Injection pun, kita tetap bisa membuat aplikasi

Namun ketika relasi antar dependencies sangat kompleks, agak ribet untuk kita melakukannya jika harus manual

Oleh karena itu, penggunaan Dependency Injection framework seperti Spring sangat membantu sekali

Kode : Class FoorBar

Kode : Tanpa Dependency Injection

Spring Dependency Injection
Spring sejak awal dikenal dengan framework untuk Dependency Injection

Ketika kita membuat method untuk bean di Spring, kita bisa menambahkan parameter

Secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut

Jika ternyata tidak ada bean yang cocok, maka secara otomatis akan terjadi error

Dan jika ternyata terdapat bean lebih dari satu, secara otomatis akan terjadi error, kecuali terdapat primary bean

Kode : Bean Dependency Injection

Kode : Menggunakan Dependency Injection

 

Memilih Dependency
Kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan

Saat terdapat duplicate bean dengan tipe data yang sama, secara otomatis Spring akan memilih bean yang primary

Namun kita juga bisa memilih secara manual jika memang kita inginkan

Kita bisa menggunakan annotation @Qualifier(value=”namaBean”) pada parameter di method nya

Kode : Memilih Dependency

Kode : Mengakses Bean

 

Circular Dependencies
Hati-hati dengan curcular dependencies

Circular dependencies adalah kasus dimana sebuah lingkaran dependency terjadi, misal bean A membutuhkan bean B, bean B membutuhkan bean C, dan ternyata bean C membutuhkan A

Jika terjadi cyclic seperti ini, secara otomatis Spring bisa mendeteksinya, dan akan mengganggap bahwa itu adalah error

Kode : Contoh Circular Configuration

Kode : Error Circular Dependencies

 

Depends On
Saat sebuah bean membutuhkan bean lain, secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat
Namun bagaimana jika bean tersebut tidak membutuhkan bean lain, namun kita ingin sebuah bean dibuat setelah bean lain dibuat?
Jika ada kasus seperti itu, kita bisa menggunakan annotation @DependsOn(value={”namaBean”})
Secara otomatis, Spring akan memprioritaskan pembuatan bean yang terdapat di DependsOn terlebih dahulu
Kode : Depends On
 

Lazy Bean
Secara default, bean di Spring akan dibuat ketika aplikasi Spring pertama kali berjalan
Oleh karena itu, kadang ketika aplikasi Spring pertama berjalan akan sedikit lambat, hal ini dikarenakan semua bean akan dibuat di awal
Namun jika kita mau, kita juga bisa membuat sebuah bean menjadi lazy (malas), dimana bean tidak akan dibuat, sampai memang diakses atau dibutuhkan
Untuk membuat sebuah bean menjadi lazy, kita bisa tambahkan annotation @Lazy pada bean tersebut
Kode : Lazy Bean
 

Scope
Scope merupakan strategy cara sebuah object dibuat
Secara default strategy object di Spring adalah singleton, artinya hanya dibuat sekali, dan ketika kita akses, akan mengembalikan object yang sama
Namun kita juga bisa mengubah scope bean yang kita mau di Spring
Untuk mengubah scope sebuah bean, kita bisa tambahkan annotation @Scope(value=”namaScope”)
