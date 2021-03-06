package org.apache.cayenne.testdo.testmap.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.testdo.testmap.Painting;

/**
 * Class _PaintingInfo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PaintingInfo extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String PAINTING_ID_PK_COLUMN = "PAINTING_ID";

    public static final Property<byte[]> IMAGE_BLOB = new Property<>("imageBlob");
    public static final Property<String> TEXT_REVIEW = new Property<>("textReview");
    public static final Property<Painting> PAINTING = new Property<>("painting");

    public void setImageBlob(byte[] imageBlob) {
        writeProperty("imageBlob", imageBlob);
    }
    public byte[] getImageBlob() {
        return (byte[])readProperty("imageBlob");
    }

    public void setTextReview(String textReview) {
        writeProperty("textReview", textReview);
    }
    public String getTextReview() {
        return (String)readProperty("textReview");
    }

    public void setPainting(Painting painting) {
        setToOneTarget("painting", painting, true);
    }

    public Painting getPainting() {
        return (Painting)readProperty("painting");
    }


}
