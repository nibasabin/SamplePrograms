<?php
require'connect.php';
  session_start();
 
$SearchResult=$_GET['id'];

if($_POST)
{
    
    $selected=$_POST['Buy'];
        
     $result2 = mysql_query("SELECT * FROM SellItem");
  
    while($row2 = mysql_fetch_array($result2))
    {  
        if($selected==$row2['ItemId'])
        {   
            $status=FALSE;
             $sql=  mysql_query("UPDATE SellItem SET Status=FALSE WHERE ItemId='$selected'");
        }
    }
}
      function MarketList()
{
     $SearchResult=$_SESSION['result'];
     $result = mysql_query("SELECT * FROM SellItem");
    while($row = mysql_fetch_array($result))
    {  
        if($SearchResult==$row['ItemName'])
        {
        echo ("</option><option value = ".$row['ItemId'].">".$row['ItemId']."</option>");
        }
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
               #box2b
        {
            height:100px;
            width:100px;
            background-color:#cccccc;
            float:right;
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
                
                $SearchResult=$_GET['id'];
               // $SearchResult=$_SESSION['result'];
               // echo"this is what i need:".$SearchResult.'walla'.'<br>';
              //  echo"this is what i needdddddd:".$SearchResults;
               

                echo "<center><label style='color:#ffff00'><u>Click on the picture to zoom </u></label></center>"."<br>";
                  $result = mysql_query("SELECT * FROM SellItem");
                    while($row = mysql_fetch_array($result))
                    {
                      
                         if($SearchResult==$row['ItemId'])
                         {
                        $filename=$row['ItemPicture'];
                        $ItemName=$row['ItemName'];
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
                    
                        $link="<a href='/sabin/picture/$filename'><image style='height:100px; margin-left:20px;width:100px'src=/sabin/picture/$filename></a></image>"."<br>";
                        echo $link;
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemId']."<br>";
                        echo"<label style='margin-left:20px'>Item Name :</label>"." ".$row['ItemName']."<br>";
                                    echo"<label style='margin-left:20px'>Price :$</label>"." ".$ItemPrice."<br>";
                        echo"<label style='margin-left:20px'>Seller :</label>"." ".$row['Fname']." ".$row['Lname']."<br>";
                        echo"<label style='margin-left:20px'>Contact :</label>"." ".$contact."<br>";
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row['ItemDescription']."<br>";
                        echo"<label style='margin-left:20px'>Status :</label>"." ".$status."<br>";
                        echo"<hr>";
                       
                        
                        
                         }  
                    }
                    
                    $result2 = mysql_query("SELECT * FROM TradeItem");
                    while($row2 = mysql_fetch_array($result2))
                    {
                      
                         if($SearchResult==$row2['TradeId'])
                         {
                        $filename1=$row2['ItemPicture'];
                        $ItemName=$row2['ItemName'];
                        $ItemSellerId1=$row2['ItemSellerID'];
                        $Fname1=$row2['Fname'];
                        $Lname1=$row2['Lname'];
                        $TradeWith1=$row2['TradeWith'];
                       
                         if($row['Status']==TRUE)
                        {
                            $status1='Available';
                            
                        }
                        else
                        {
                            $status1='Sold';
                        }
                       $result3 = mysql_query("SELECT * FROM Registration");
                        while($row3 = mysql_fetch_array($result3))
                        {
                            
                            if($ItemSellerId1==$row3['Id'])
                            {
                                $contact1=$row3['Email'];
                            }
                        }
                       
                        $link="<a href='/sabin/picture/$filename1'><image style='height:100px; margin-left:20px;width:100px'src=/sabin/picture/$filename1></a></image>"."<br>";
                        echo $link;
                        echo"<label style='margin-left:20px'>Trade No :</label>"." ".$row2['TradeId']."<br>";
                        echo"<label style='margin-left:20px'>Item Name :</label>"." ".$row2['ItemName']."<br>";
                        echo"<label style='margin-left:20px'>Trade With :</label>"." ".$TradeWith1."<br>";
                        echo"<label style='margin-left:20px'>Seller :</label>"." ".$Fname1." ".$Lname1."<br>";
                        echo"<label style='margin-left:20px'>Contact :</label>"." ".$contact1."<br>";
                        echo"<label style='margin-left:20px'>Item No :</label>"." ".$row2['ItemDescription']."<br>";
                        echo"<label style='margin-left:20px'>Status :</label>"." ".$status1."<br>";
                        echo"<hr>";
                       
                        
                        
                         }  
                    }
                ?>
            </div>
            <div id="box2"><br><br>
                 <div id="box2b">
                     
                           <?php
                            $User= $_SESSION['user'];
                            $Pass=$_SESSION['pass'];
                     if(($User=='Admin')&&($Pass=='Admin123'))
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
               <br><br><br><br><br><br>
                
                
            <form method="post">
                <center>
            <select name='Buy'style="height:25px; width:100px">
                    
            <option>Select Item</option>
            <?php echo MarketList();?>
            </select>
                <input type="submit" value="Commit To Buy" style="height:25px;width:100px;margin:auto;color:white;background-color:#0000FF">
                </center>
            </form><br>
            <form action="Search.php">
                <center>    <input type="submit" value="Back" style="height:45px;width:175px;margin:auto;color:white;background-color:#0000FF"></center>
            </form>
           
           
            
            </div>
            
        </div>
        
    </body>
</html>