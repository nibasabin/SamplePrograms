<?php
require'connect.php';
session_start();
$username=$_SESSION['user'];
$password=$_SESSION['pass'];
if($_POST)
{
    
$selected=$_POST['Delete'];
   if($selected=='Delete Item')
    {
         echo "<script type='text/javascript'>alert('Please Select Post To Delete');</script>";
    }
    else
    {
        
     $result = mysql_query("SELECT * FROM Registration");
    while($row = mysql_fetch_array($result))
    {  
        if(($username==$row['UserName'])&&($password==$row['Password']))
        {
            $Id=$row['Id'];
        }
    }
    
    $result2 = mysql_query("SELECT * FROM SellItem");
    while($row2 = mysql_fetch_array($result2))
    {   
        if(($Id==$row2['ItemSellerID'])||($Id==$row2['AdminId']))
        {
          mysql_query("DELETE FROM SellItem WHERE ItemId='$selected'");
             echo "<script type='text/javascript'>alert('Post Deleted');</script>";
        }
        elseif($Id!=$row2['ItemSellerID'])
        {
               echo "<script type='text/javascript'>alert('You are not autorized to delte this post');</script>";
               break;
        }
    }
    }
}
    function MarketList()
{
     $result = mysql_query("SELECT * FROM SellItem");
    while($row = mysql_fetch_array($result))
    {   
       echo ("</option><option value = ".$row['ItemId'].">".$row['ItemId']."</option>");
    }
}

?>

<html>
    <title>Market</title>
 <head >
    <div style="height:150px">
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
    </div>
    </head>
    <style>
        #container
        {
        height:500px;
        width:800px;
        border-style:solid;
        border-width:1px;
        margin:auto;
        }
        #box1
        {
        height:500px;
        width:550px;
        background-color:#666666;
        float:left;
        color:white;
        overflow:scroll;
        }
        #box2
        {
        height:500px;
        width:250px;
        background-color:#006666;
        float:right;
        }
                  #box2b
        {
            height:100px;
            width:100px;
            background-color:#cccccc;
      
            margin-right:50px;
            
            
        }
           #box2b:hover
        {
            background-color:#0000FF;
        }
        a:hover
        {
            
            cursor: pointer;
    height:475px;
    width: 350px;
        }
       
    </style>
    <body style="background-color:#cccccc">
        <div id="container">
            <div id="box1"><br>
                <?php 
                require'connect.php';
                //session_start();
                echo "<center><label style='color:#ffff00'><u>Click on the picture to zoom </u></label></center>"."<br>";
                  $result = mysql_query("SELECT * FROM SellItem");
                    while($row = mysql_fetch_array($result))
                    {
                        $filename=$row['ItemPicture'];
                        $ItemId=$row['ItemId'];
                        $ItemPrice=$row['ItemPrice'];
                        $ItemSellerId=$row['ItemSellerID'];
                        $Fname=$row['Fname'];
                        $Lname=$row['Lname'];
                        if($row['Status']==TRUE)
                        {
                            $status='Available';
                            
                        }
                        else
                        {
                            $status='Sold';
                        }
                       $result1 = mysql_query("SELECT * FROM Registration");
                        while($row1 = mysql_fetch_array($result1))
                        {
                            if($ItemSellerId==$row1['Id'])
                            {
                                $contact=$row1['Email'];
                            }
                        }
                        if($ItemSellerId!=1000)
                        {
                        $link="<a href='/sabin/picture/$filename'><image style='height:100px; margin-left:20px;width:100px'src=/sabin/picture/$filename></a></image>"."<br>";
                        echo $link;
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemId']."<br>";
                        echo"<label style='margin-left:20px'>Item Name :</label>"." ".$row['ItemName']."<br>";
                        echo"<label style='margin-left:20px'>Price :</label>"." "."$".$row['ItemPrice']."<br>";
                        echo"<label style='margin-left:20px'>Seller :</label>"." ".$row['Fname']." ".$row['Lname']."<br>";
                        echo"<label style='margin-left:20px'>Contact :</label>"." ".$contact."<br>";
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemDescription']."<br>";
                        echo"<label style='margin-left:20px'>Status :</label>"." ".$status."<br>";
                        echo"<hr>";
                        }
                        
                    }
                ?>
            </div>
            <div id="box2"><br>
                <center>  <div id="box2b">
                           <?php
                     if(($username=='Admin')&&($password=='Admin123'))
                     {
                         $site="AdminPage.php";
                     }
                     else
                     {
                         $site="UserPage.php";
                     }
                     ?>
                     <a href=<?php echo $site;?>>  <img  src="\sabin\picture\home.jpg" alt= " Image not found" style=";padding:2px; height:95px; width:95px" ></a>
                    </div>
                <br>
                <br>
                
                    <form action="ItemBuy.php">
                        <input type="submit" name="submit1" value="Buy Item" style="height:50px;width:225px;color:white;background-color:#0000FF"><br>
                    </form>
                        <form action="ItemSell.php">
                            <input type="submit" name="submit2" value="Sell Item" style="height:50px;width:225px;color:white;background-color:#0000FF"><br>
                        </form>
                    <form action="TradeMarket.php">
                          <input type="submit" name="submit3" value="Trade Item" style="height:50px;width:225px;color:white;background-color:#0000FF"><br>
               
                    </form> 
           
             
                     <form method="post">
                    <select name='Delete'style="height:25px; width:100px">
            <option>Delete Item</option>
            <?php echo MarketList();?>
            </select>
                     <input type="submit" value="Delete Post" style="height:25px;width:100px;margin:auto;color:white;background-color:#0000FF">
                     </form></center>
            </div>
            
        </div>
        
    </body>
</html>