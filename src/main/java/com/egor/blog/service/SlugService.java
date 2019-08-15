package com.egor.blog.service;

import com.github.slugify.Slugify;
import com.ibm.icu.text.Transliterator;

public class SlugService {
    public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    public  String makeSlug(String title) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String latinTitle = toLatinTrans.transliterate(title);
        Slugify slug = new Slugify();
        String result = slug.slugify(latinTitle);

        return result;
    }
}
