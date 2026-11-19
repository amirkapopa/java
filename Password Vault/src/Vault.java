import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Vault {
    private final Map<String, Credential> entries=new HashMap<>();//Map<String, Credential>, not a List. To find “gmail + amir” in a List you’d loop through every entry. A Map jumps straight to it by key.

    private static String keyOf(String site,String username){
        return site.trim().toLowerCase() + "|" + username.trim();//trim  removes spaces at the start and end of a String (not in the middle)
    }
    public boolean  add(Credential credential){ //We want the key to identify the whole login: site and username. That’s exactly what keyOf is for, so call it:
        String key=keyOf(credential.getSite(),credential.getUsername());
        Credential previous=entries.put(key,credential);
        if(previous!=null){
            return false;
        }
        else return true;
    }

    public Credential find( String site, String username){
        String key=keyOf(site,username);// make the label
        Credential found = entries.get(key);// open that locker
        if (found == null){
            throw new EntryNotFoundException("No entry for " + site);
        }
        return found;
    }

    public boolean remove( String site, String username) {
        String key=keyOf(site,username);
        Credential found=entries.remove(key);
        return found!=null;
    }

    public boolean contains( String site, String username){
        String key=keyOf(site,username);
        return entries.containsKey(key);
    }

    public int size() {
        return entries.size();
    }

    public Collection<Credential> getAll() {
        return Collections.unmodifiableCollection(entries.values());
    }

}//vault
