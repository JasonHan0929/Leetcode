public class Codec {
    
    private final Map<String, String> index = new HashMap<>();
    private final Map<String, String> revIndex = new HashMap<>();
    private final String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int length = 6;
    private final Random random;
    private final String baseUrl = "http://tinyurl.com/";
    
    public Codec() {
        random = new Random(System.currentTimeMillis());
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (index.containsKey(longUrl)) return index.get(longUrl);
        String key = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(charset.charAt(random.nextInt(charset.length())));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        revIndex.put(key, longUrl);
        index.put(longUrl, key);
        return baseUrl + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return revIndex.get(shortUrl.replace(baseUrl, ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

/*
My first solution produces short URLs like http://tinyurl.com/0, http://tinyurl.com/1, etc, in that order.

class Codec:

    def __init__(self):
        self.urls = []

    def encode(self, longUrl):
        self.urls.append(longUrl)
        return 'http://tinyurl.com/' + str(len(self.urls) - 1)

    def decode(self, shortUrl):
        return self.urls[int(shortUrl.split('/')[-1])]
Using increasing numbers as codes like that is simple but has some disadvantages, which the below solution fixes:

If I'm asked to encode the same long URL several times, it will get several entries. That wastes codes and memory.
People can find out how many URLs have already been encoded. Not sure I want them to know.
People might try to get special numbers by spamming me with repeated requests shortly before their desired number comes up.
Only using digits means the codes can grow unnecessarily large. Only offers a million codes with length 6 (or smaller). Using six digits or lower or upper case letters would offer (10+26*2)6 = 56,800,235,584 codes with length 6.
The following solution doesn't have these problems. It produces short URLs like http://tinyurl.com/KtLa2U, using a random code of six digits or letters. If a long URL is already known, the existing short URL is used and no new entry is generated.

class Codec:

    alphabet = string.ascii_letters + '0123456789'

    def __init__(self):
        self.url2code = {}
        self.code2url = {}

    def encode(self, longUrl):
        while longUrl not in self.url2code:
            code = ''.join(random.choice(Codec.alphabet) for _ in range(6))
            if code not in self.code2url:
                self.code2url[code] = longUrl
                self.url2code[longUrl] = code
        return 'http://tinyurl.com/' + self.url2code[longUrl]

    def decode(self, shortUrl):
        return self.code2url[shortUrl[-6:]]
It's possible that a randomly generated code has already been generated before. In that case, another random code is generated instead. Repeat until we have a code that's not already in use. How long can this take? Well, even if we get up to using half of the code space, which is a whopping 626/2 = 28,400,117,792 entries, then each code has a 50% chance of not having appeared yet. So the expected/average number of attempts is 2, and for example only one in a billion URLs takes more than 30 attempts. And if we ever get to an even larger number of entries and this does become a problem, then we can just use length 7. We'd need to anyway, as we'd be running out of available codes.
*/
