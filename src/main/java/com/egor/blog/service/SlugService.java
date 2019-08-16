package com.egor.blog.service;

import com.github.slugify.Slugify;
import com.ibm.icu.text.Transliterator;
import org.springframework.stereotype.Service;

@Service
public class SlugService {
    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    public  String makeSlug(String title) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String latinTitle = toLatinTrans.transliterate(title);
        System.out.println(latinTitle);
        Slugify slug = new Slugify();
        String result = slug.slugify(latinTitle);
        System.out.println(result);
        return result;
    }
}
