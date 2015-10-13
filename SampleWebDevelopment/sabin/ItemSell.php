<?php
require'connect.php';
session_start(); 
$username=$_SESSION['user'];
$password=$_SESSION['pass'];

$ItemSellerId='';
$ItemPicture='';
$Fname='';
$Lname='';


if (isset($_POST['submit1']))
{

  
    $ItemName=$_POST['ItemName'];
    $ItemPrice=$_POST['ItemPrice'];
    $ItemDescription=$_POST['ItemDescription'];
    $ItemPicture=  \addslashes($_FILES["file"]["name"]);
    $temp=$_FILES["file"]["tmp_name"];
    $error=$_FILES["file"]["error"];
    $_SESSION['ItemName']=$ItemName;
    $_SESSION['ItemPrice']=$ItemPrice;
    
      
 
   
    if($error>0)
    {
        echo" error uploading file $error";
    }
    else
    {
 
    move_uploaded_file($temp,"/Applications/XAMPP/xamppfiles/htdocs/sabin/picture/".$ItemPicture);
      echo "<script type='text/javascript'>alert('Picture Successfully Uploaded');</script>";
    }
    
    $result = mysql_query("SELECT * FROM Registration");
    while($row = mysql_fetch_array($result))
    {   
        if(($username==$row['UserName'])&&($password==$row['Password']))
        {
           $ItemSellerId=$row['Id'];
            $Fname=$row['Name'];
            
            $Lname=$row['LastName'];
            $status=TRUE;
         
        }
    }
        $Admin=1000;
     mysql_query("INSERT INTO SellItem(ItemName,ItemPrice,ItemDescription,ItemPicture,ItemSellerID,Fname,Lname,Status,AdminId)"
                    . "VALUES('$ItemName','$ItemPrice','$ItemDescription','$ItemPicture','$ItemSellerId','$Fname','$Lname','$status','$Admin')");
    
}
if (isset($_POST['submit3']))
{
    header('Location:Market.php');
}
?>
<html>
    <title>Sell Item</title>
 <head >
    <div style="height:200px">
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
    </div>
    </head>
    <style>
        #container
        {
        height:350px;
        width:650px;
        border-style:solid;
        border-width:1px;
        margin:auto;
        background-color:#666666;
        }
        #box1
        {
        height:310px;
        width:450px;
        background-color:#666666;
        float:left;
        }
         #box1a
        {
        height:307px;
        width:150px;
        background-color:#666666;
        float:left;
        }
        #box1b
        {
        height:307px;
        width:300px;
        background-color:#666666;
        float:right;
        }
        #box2
        {
        height:350px;
        width:200px;
        background-color:#006666;
        float:right;
        }
        
       
    </style>
    <body>
       
        <div id="container">
          <form  method="post" enctype="multipart/form-data">
              <div id="box1"><br>
                  <center> <label style="color:white;font-size:20px"> Sell Item:</label></center>
                     
                <div id="box1a"><br>
                    
                    <label style="margin-left:30px;color:white;font-size:20px"> Item Name:</label><br><br>
                    <label style="margin-left:30px;color:white;font-size:20px"> Price:</label><br><br>
                    <label style="margin-left:30px;color:white;font-size:20px"> Description:</label><br><br><br><br><br>
                   <label style="margin-left:30px;color:white;font-size:16px">Picture:</label><br><br>
                </div>
                
                
                <div id="box1b"><br>
                    
                    
                        <input type="text" name="ItemName" style="width:250px;height:25px"><br><br>
                        <input type="number" name="ItemPrice" style="width:250px;height:25"><br><br>
                        <textarea name="ItemDescription" style="width:250px;height:90px"></textarea><br><br>
                        <input type="file" name="file" style="height:25px;width:250px">
                     
                </div>
            </div>
            <div id="box2"><br><br><br>
                <center>
               
                <input type="submit" name="submit1" value="Post Item" style="height:25px;width:150px;color:white;font-size:16px;background-color:#0000FF"><br><br>
                
                
                <input type="submit" name="submit3" value="Back" style="height:30px;width:150px;color:white;font-size:16px;background-color:#0000FF"><br>
                

                </center>
               

            </div>
            
            </form>


             </div>
        
    </body>
</html>