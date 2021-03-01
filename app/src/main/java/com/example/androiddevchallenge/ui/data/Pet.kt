/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet(
    var image: String,
    var name: String,
    var type: String,
    var description: String,
    var coat: String,
    var color: String,
    var size: String,
    var isMale: Boolean
) : Parcelable

fun petData(): ArrayList<Pet> {
    val petList = ArrayList<Pet>()
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Abyssinian_body_7.jpg?itok=E0O3mW9s", "Sonara",
            "Abyssinian Cat", "Abyssinians are highly intelligent and intensely inquisitive. They love to investigate and will leave no nook or cranny unexplored. They’re sometimes referred to as “Aby-grabbys” because they tend to take things that grab their interest. The playful Aby loves to jump and climb. Keep a variety of toys on hand to keep her occupied, including puzzle toys that challenge her intelligence.",
            "Medium", "Ruddy, red, blue, fawn", "Small to medium, with males weighing 7 to 10 pounds and females weighing 6 to 8 pounds", true
        )
    )
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Javanese_body_6.jpg?itok=qgJ2m3sj", "Shiro",
            "Balinese-Javanese Cat Breed", "The Balinese, also known as Javanese depending on coat color and pattern, is regal and aristocratic in appearance, but a curious kitten at heart.",
            "Medium", "Balinese - seal point, chocolate point, blue point and lilac point, plus various patterns and shadings; Javanese – red point, cream point and seal point, plus various patterns and shadings",
            "Medium", false
        )
    )
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Birman_body_6.jpg?itok=sxZZT4Xl", "Dongala",
            "Birman Cat Breed", "The Birman is a cat of distinction as well as legend. With their exotic ancestry, luxurious pointed coats, “white gloved” paws and mesmerizing blue eyes, this is a breed with undeniable charisma.",
            "Medium to Long", "Seal point, blue point, chocolate point, lilac point", "Medium to Large", false
        )
    )
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Chartruese_body_6.jpg?itok=BRVxtf4e", "Abasa",
            "Chartreux Cat Breed", "Often called the smiling cat of France, the Chartreux has a sweet, smiling expression. This sturdy, powerful cat has a distinctive blue coat with a resilient wooly undercoat. Historically known as fine mousers with strong hunting instincts, the Chartreux enjoys toys that move. This is a slow-maturing breed that reaches adulthood in three to five years. A loving, gentle companion, the Chartreux forms a close bond with her family.",
            "Medium", "Any shade of blue, from ash to slate", "Medium to large, with males weighing 10 to 15 pounds and females weighing 6 to 11 pounds", true
        )
    )
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/DevonRex_body_7.jpg?itok=XwV8N4K2", "Sonia",
            "Devon Rex Cat Breed",
            "The story of the Devon Rex began around 1960 in Devon, England. Here, a feral tomcat with a curly coat sired a litter of kittens with a feral tortoiseshell queen adopted by cat fancier Beryl Cox.\n" +
                "One of the kittens in the litter was curly coated, just like the sire—the result of a rex mutation, a genetic variation in mammals that causes soft, curly fur. Miss Cox named the kitten Kirlee.\n" +
                "\n" +
                " Miss Cox learned that another cat with rexed hair, named Kallibunker, had been born 10 years earlier in Cornwall. This was the last known rexed kitten born in England, so she allowed the Cornwall breeders to buy Kirlee, to help them produce more.\n" +
                " Attempts to breed the two cats didn’t produce more curly-haired kittens. After further breeding exploration successfully produced more rexed cats, breeders discovered that the Cornwall and Devon cats didn’t share the same rex genotype.\n" +
                "\n" +
                " The two different genotypes produced two slightly different rexed cats. Unlike the Cornwall rexed cat, the Devon rexed offspring had coats with tighter curls, missing or stubby whiskers, and huge ears situated lower on their heads.  \n" +
                " The breeds were eventually recognized as two distinct entities, the Cornish Rex and the Devon Rex.\n" +
                "\n" +
                " All Devon Rex cats can be traced back to Kirlee, their original ancestor.",
            "Short", "White, black, blue, red, cream, chocolate, lavender, cinnamon and fawn, plus various patterns and shadings",
            "Small to Medium", true
        )
    )
    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Himilayan_body_6.jpg?itok=kfHPy_Fe", "Molly",
            "Himalayan Cat Breed",
            "In 1931, cat breeder Virginia Cobb, together with Dr. Clyde Keeler of Harvard, began crossing the Persian with the Siamese to study how the colorpoint gene was passed on. In the 1950s, breeders in Britain and North America worked to further develop the breed using Cobb’s and Keeler’s methods. Once the breed was firmly established, they sought recognition from cat associations.\n" +
                "\n" +
                "The Cat Fanciers Association (CFA) acknowledged the Himalayan as a distinct breed in 1957, but in 1984, reclassified the breed as a variety of Persian. The International Cat Association (TICA) recognizes the breed as part of their Persian group, but the American Cat Fanciers Association (ACFA) and other associations give the Himalayan her own group.",
            "Long", "White to fawn body with color points that include chocolate", "Medium to large, with males weighing 9 to 14 pounds and females weighing 7 to 11 pound",
            false
        )
    )

    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/JapaneseBobtailSHOddEyed_body_6.jpg?itok=NKs7mhNI", "Jena",
            "Japanese Bobtail Cat Breed", "One of the oldest cat breeds, the Japanese Bobtail is believed to bring good luck and prosperity. The two coat varieties, longhair and shorthair, are exactly the same except for coat length. This delightfully mischievous feline enjoys a good game of fetch and likes to carry things in her mouth. A healthy breed that lives an average of 15 to 18 years, the Japanese Bobtail is social and particularly good with children.",
            "Long (longhaired) and short (shorthaired)", "White, black, red, blue and cream, plus various patterns and shadings", "Medium, with males weighing 7 to 10 pounds and females weighing 5 to 7 pounds",
            false
        )
    )

    petList.add(
        Pet(
            "https://www.purina.com/sites/g/files/auxxlc196/files/styles/kraken_generic_max_width_240/public/Peterbald_body_6.jpg?itok=EV0060DJ", "PanPie",
            "Peterbald Cat Breed", "The elegant naked Peterbald is an athletic breed that looks like she is performing aerial ballet when she plays. This highly intelligent, social feline gets along well with adults, children, dogs, and other pets, but does not like to be left alone for long periods. The Peterbald’s curiosity and spirited nature are entertaining, and her affectionate disposition makes her a beloved companion.",
            "Hairless", "All colors and/or markings are acceptable", "Small to medium, with males weighing 8 to 10 pounds and females weighing 6 to 8 pounds",
            true
        )
    )

    return petList
}
