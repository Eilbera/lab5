package tiktokers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * An implementation of the AddressBook interface that uses an array list to
 * store the data.
 */
public class ArrayListMyTikTokManager implements MyTikTokManager
{

   private ArrayList<Item> items = new ArrayList<Item>();
   private String source;
   private boolean modified;

   public void load(String sourceName)
   {
      source = sourceName;
      try
      {
         Scanner in = new Scanner(new File(source));
         items = new ArrayList<Item>();
         while (in.hasNextLine())
         {
            items.add(new Item(in.nextLine(), in.nextLine(), in.nextLine()));
         }
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
         source = null;
         items = new ArrayList<Item>();
      }
   }

   public String get(String username, String key)
   {
      for (Item it : items)
      {
         if (username.equals(it.getUserName()) && key.equals(it.getKey()))
         {
            return it.getValue();
         }
      }
      return null;
   }

   public String put(String username, String key, String value)
   {
      modified = true;
      for (Item it : items)
      {
         if (username.equals(it.getUserName()) && key.equals(it.getKey()))
         {
            String oldValue = it.getValue();
            it.setValue(value);
            return oldValue;
         }
      }
      items.add(new Item(username, key, value));
      return null;
   }

   public void save()
   {
      if (!modified)
      {
         return;
      }
      try
      {
         PrintWriter out = new PrintWriter(source);
         for (Item it : items)
         {
            out.println(it.getUserName());
            out.println(it.getKey());
            out.println(it.getValue());
         }
         out.close();
         modified = false;
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public String remove(String username, String key) throws NoSuchElementException
   {
	
	 modified = false;
	 for (Item it : items)
     {
		   if (username.equals(it.getUserName()) && key.equals(it.getKey())) {
	             String val =  it.getValue();
	             Item lastelem = items.get(items.size()-1);
	             items.set(items.indexOf(it), lastelem);
	             items.remove(items.size()-1);
	  	         modified = true;
	  	         return val;
		   }
		   

	   }
	 if (modified == false) {
		   throw new NoSuchElementException("name not in list");
	   }
	 
		return null;

//       throw new UnsupportedOperationException("Not supported yet.");
   }  
	public static void main(String[] args) { 

   ArrayListMyTikTokManager tik = new ArrayListMyTikTokManager();
//   tik.put("@name", "1000", "2000");
//   tik.remove("@name", "1000");
 
	}
}
