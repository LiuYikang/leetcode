/**
535. Encode and Decode TinyURL

Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

题目中明确推荐了使用六位随机字符来编码，
那么我们只要在所有大小写字母和数字中随机产生6个字符就可以了，
我们用哈希表建立6位字符和url之间的映射，
如果随机生成的字符之前已经存在了，我们就继续随机生成新的字符串，直到生成了之前没有的字符串为止。
**/


public class Codec {
    Map<Integer, String> map1 = new HashMap<Integer, String>();
    Map<String, Integer> map2 = new HashMap<String, Integer>();
    String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!map2.containsKey(longUrl)) {
            map1.put(map1.size() + 1, longUrl);
            map2.put(longUrl, map2.size() + 1);
        }
        int n = map2.get(longUrl);
        StringBuilder sb = new StringBuilder();
        //首先每个longUrl的索引n是不同的，可以使用对62的商和余数唯一标识n，然后将s中相应位置的字符插入短连接即可。
        while(n > 0) {
        //共有62个字符可以用于短连接的编码
            int r = n % 62;
            n / = 62;
            sb.insert(0, s.charAt(r));
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int val = 0;
        int n = shortUrl.length();
        for(int i = 0; i < n; i++) {
            val = val * 62 + s.indexOf(shortUrl.charAt(i));
        }
        return map1.get(val);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
