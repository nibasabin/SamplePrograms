<?php
require'connect.php';
session_start();
$username=$_SESSION['user'];
$password=$_SESSION['pass'];
if($_POST)
{
    
$selected=$_POST['Delete'];
        
     $result = mysql_query("SELECT * FROM Registration");
    while($row = mysql_fetch_array($result))
    {  
        if(($username==$row['UserName'])&&($password==$row['Password']))
        {
            $Id=$row['Id'];
        }
    }
    
    $result2 = mysql_query("SELECT * FROM TradeItem");
    while($row2 = mysql_fetch_array($result2))
    {   
         if(($Id==$row2['ItemSellerID'])||($Id==$row2['AdminId']))
        {
          mysql_query("DELETE FROM TradeItem WHERE TradeId='$selected'");
             echo "<script type='text/javascript'>alert('Post Deleted');</script>";
        }
        elseif($Id!=$row2['ItemSellerID'])
        {
               echo "<script type='text/javascript'>alert('You are not autorized to delte this post');</script>";
               break;
        }
    }
}
    function MarketList()
{
     $result = mysql_query("SELECT * FROM TradeItem");
    while($row = mysql_fetch_array($result))
    {   
       echo ("</option><option value = ".$row['TradeId'].">".$row['TradeId']."</option>");
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
        width:500px;
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
               echo "<center><label style='color:#ffff00'><u>Click on the picture to zoom</u></label></center>"."<br>";
                  $result = mysql_query("SELECT * FROM TradeItem");
                    while($row = mysql_fetch_array($result))
                    {
                        $filename=$row['ItemPicture'];
                        $TradeId=$row['TradeId'];
                        $TradeWith=$row['TradeWith'];
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
                        $link="<a href='/sabin/picture/$filename'><image style='height:100px; margin-left:20px;width:100px'src=/sabin/picture/$filename></a></image>"."<br>";
                        echo $link;
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['TradeId']."<br>";
                        echo"<label style='margin-left:20px'>Item Name :</label>"." ".$row['ItemName']."<br>";
                        echo"<label style='margin-left:20px'>Price :</label>"." "."$".$row['TradeWith']."<br>";
                        echo"<label style='margin-left:20px'>Seller :</label>"." ".$row['Fname']." ".$row['Lname']."<br>";
                        echo"<label style='margin-left:20px'>Contact :</label>"." ".$contact."<br>";
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemDescription']."<br>";
                        echo"<label style='margin-left:20px'>Status :</label>"." ".$status."<br>";
                        echo"<hr>";
                       
                        
                    }
                ?>
            </div>
            <div id="box2">
                <br><br>
                <center>
                   
                    <form action="ItemTrade.php">
                        <br>  <input type="submit" name="submit3" value="Post Item" style="height:50px;width:225px;color:white;background-color:#0000FF"><br>
               
                    </form> 
           
                <form action="Market.php"><br>
                    <input type="submit" value="Go Back" style="height:50px;width:225px;margin:auto;color:white;background-color:#0000FF"><br><br>
                </form> 
                     <form method="post">
                    <select name='Delete'style="height:50px; width:115px">
            <option>Delete Item</option>
            <?php echo MarketList();?>
            </select>
                     <input type="submit" value="Delete Post" style="height:50px;width:100px;margin:auto;color:white;background-color:#0000FF">
                     </form></center>
            </div>
            
        </div>
        
    </body>
</html>