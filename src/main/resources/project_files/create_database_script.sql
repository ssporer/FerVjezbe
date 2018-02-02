create database image_gallery default character set utf8;
create user 'image_gallery_admin'@'localhost' identified by 'admin';
grant all on image_gallery.* to 'image_gallery_admin'@'localhost';