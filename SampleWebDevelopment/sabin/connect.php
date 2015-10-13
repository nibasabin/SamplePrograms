<?php
$dbhost='localhost';
$dbuser='root';
$dbpassword='';
$db='nibasabin';
$connect=mysql_connect($dbhost,$dbuser,$dbpassword);
mysql_select_db($db);

if ($connect==true)
{
   // echo" database is connected";
}


?>