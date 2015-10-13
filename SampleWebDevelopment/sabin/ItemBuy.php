<?php
require'connect.php';
if($_POST)
{
    
$selected=$_POST['Buy'];
        
     $result2 = mysql_query("SELECT * FROM SellItem");
  
    while($row2 = mysql_fetch_array($result2))
    {  
        if($selected==$row2['ItemId'])
        {   
            $status=FALSE;
        
        echo" i am here".$selected;
      
         $sql=  mysql_query("UPDATE SellItem SET Status=FALSE WHERE ItemId='$selected'");
        
  

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
        width:725px;
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
        width:225px;
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
                session_start();
                $searchresult='';
              //  $searchresult=$_SESSION['name'];
                echo "<center><label style='color:#ffff00'><u>Click on the picture to zoom</u></label></center>"."<br>";
                  $result = mysql_query("SELECT * FROM SellItem");
                    while($row = mysql_fetch_array($result))
                    {
                        $filename=$row['ItemPicture'];
                        $ItemId=$row['ItemId'];
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
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemId']."<br>";
                        echo"<label style='margin-left:20px'>Item Name :</label>"." ".$row['ItemName']."<br>";
                        echo"<label style='margin-left:20px'>Seller :</label>"." ".$row['Fname']." ".$row['Lname']."<br>";
                        echo"<label style='margin-left:20px'>Contact :</label>"." ".$contact."<br>";
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemDescription']."<br>";
                        echo"<label style='margin-left:20px'>Status :</label>"." ".$status."<br>";
                        echo"<hr>";
                       
                        
                        
                    }
                ?>
            </div>
            <div id="box2"><br><br><br>
            <form method="post">
                <center>
            <select name='Buy'style="height:25px; width:100px">
                    
            <option>Select Item</option>
            <?php echo MarketList();?>
            </select>
                <input type="submit" value="Commit To Buy" style="height:25px;width:100px;margin:auto;color:white;background-color:#0000FF">
                </center>
            </form><br>
            <form action="Market.php">
                <center>    <input type="submit" value="Back" style="height:45px;width:175px;margin:auto;color:white;background-color:#0000FF"></center>
            </form>
            </div>
            
        </div>
        
    </body>
</html>