//package careers.nebula.ben.testing;
//
///*
// * Copyright 2016 Google Inc. All Rights Reserved.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//
//import static com.google.common.truth.Truth.assertThat;
//
//import com.google.common.collect.ImmutableList;
//
//import careers.nebula.ben.google.vision.ImageText;
//import careers.nebula.ben.google.vision.TextApp;
//import careers.nebula.ben.google.vision.Word; 
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith; 
//import org.junit.runners.JUnit4;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
///**
// * Integration (system) tests for {@link TextApp}.
// **/
//@RunWith(JUnit4.class)
//@SuppressWarnings("checkstyle:abbreviationaswordinname")
//public class TextAppIT {
//  private TextApp appUnderTest;
//
//  @Before public void setUp() throws Exception {
//    appUnderTest = new TextApp(TextApp.getVisionService(), null /* index */);
//  }
//
//  @Test public void extractDescriptions_withImage_returnsText() throws Exception {
//    // Arrange
//    List<ImageText> image =
//        appUnderTest.detectText(ImmutableList.<Path>of(Paths.get("C://Users/Ankit_Nebula/Documents/Nebula_Documents/Files/texttest.png")));
//    for(ImageText i : image){
//        System.out.println(i);
//    }
//
////    // Act
////    Word word = appUnderTest.extractDescriptions(image.get(0));
////
////    // Assert
////    assertThat(word.path().toString())
////        .named("wakeupcat.jpg path")
////        .isEqualTo("../../data/text/wakeupcat.jpg");
////    assertThat(word.word().toLowerCase()).named("wakeupcat.jpg word").contains("wake");
////    assertThat(word.word().toLowerCase()).named("wakeupcat.jpg word").contains("up");
////    assertThat(word.word().toLowerCase()).named("wakeupcat.jpg word").contains("human");
//  }
//}