<?php
require'connect.php';
if($_POST)
{
  
    $Name=addslashes($_FILES["file"]["name"]);
    $temp=$_FILES["file"]["tmp_name"];
    $error=$_FILES["file"]["error"];
  
mysql_query("INSERT INTO ExtAdd(ExtAdd)"
                    . "VALUES('$Name')");

    if($error>0)
    {
        echo" error uploading file $error";
    }
    else
    {
 
    move_uploaded_file($temp,"/Applications/XAMPP/xamppfiles/htdocs/sabin/picture/".$Name);
     echo "<script type='text/javascript'>alert('Picture Successfully Uploaded');</script>";
    }
}
?>
<html>
    <title>Internal advertisement</title>

 
    <style>
        #container
        {
            height:200px;
            width:900px;
            background-color:#cccccc;
        }
        #container1
        {
            height:200px;
            width:400px;
            float:left;
            border-style:box;
            border-width: 2px;
            background-color:#666666;
           
            
        }
        #container2
        {
            height:104px;
            width:260px;
            float:right;
           
            background-color:#cccccc;
        }
     
        #box1{
         height:104px;
         width:105px;
         background-color:#cccccc;
         float:right; 
        }
        #box2{
         height:104px;
         width:105px;
         background-color:#cccccc;
         float:left; 
        }
        #box1:hover
        {
            background-color:#0000FF;
        }
        #box2:hover
        {
          background-color:#0000FF;  
        }
    </style>
    
    <html>
    
       <head >
        <div style="height:200px">
        <center> <img src="\sabin\picture\1.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        <center>  <h1 style="height:75px;width:906;background-color: #666666;font-size:30;color: white;margin:0;padding:0">
        University Bazaar
        <p1 style="font-size:16;color: white"><center> 701 W Nedderman Dr, Arlington, TX 76019 </center></p1>
                   </h1></center>
        </div>
    
    </head>
    <body style="background-color: #cccccc">
        <br><br>
    <center><div id='container'>
            <div id="container1"><br><br>
            <form method="post" enctype="multipart/form-data" >
                <input style="border-style:solid;border-color:white;float:right;width:400px;height:30px"type="file" name="file"><br><br><br><br>
            <input type="submit" value="Submit" name='submit' style="height:30px;width:150px;background-color:#0000FF;color:white;font-size:16;">
            </form> 
            </div>
             <div id="container2">
                 <div id="box1">
                     <a href="AdminPage.php"><img src="\sabin\picture\Home.jpg" alt= " Image not found" style="padding:3;float:left;height:98; width:98"></a>
                </div>
                <div id="box2">
                    <a href="Login.php"><img src="\sabin\picture\Logoff.png" alt= " Image not found" style="padding:3; float:right;height:98; width:98"></a>
                </div>
                    
             </div>
          
        
        </div></center>
       
    </body>
</html>
    
</html>
    
 