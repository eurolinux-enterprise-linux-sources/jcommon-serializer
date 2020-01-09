/**
 * ===================================================
 * JCommon-Serializer : a free serialization framework
 * ===================================================
 *
 * Project Info:  http://reporting.pentaho.org/jcommon-serializer/
 *
 * (C) Copyright 2006-2008, by Object Refinery Limited, Pentaho Corporation and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ------------
 * GradientPaintSerializer
 * ------------
 */
package org.jfree.serializer.methods;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jfree.serializer.SerializeMethod;

/**
 * SerializeMethod for GradientPaint objects.
 *
 * @author Thomas Morgner
 */
public class GradientPaintSerializer implements SerializeMethod
{
  /**
   * Default constructor.
   */
  public GradientPaintSerializer()
  {
  }

  /**
   * Writes a serializable object description to the given object output
   * stream.
   *
   * @param o      the to be serialized object.
   * @param stream the outputstream that should receive the object.
   * @throws IOException if an I/O error occured.
   */
  public void writeObject(Object o, ObjectOutputStream stream) throws IOException
  {
    final GradientPaint gp = (GradientPaint) o;
    final Point2D point2D1 = gp.getPoint1();
    stream.writeFloat((float) point2D1.getX());
    stream.writeFloat((float) point2D1.getY());
    stream.writeObject(gp.getColor1());
    final Point2D point2D = gp.getPoint2();
    stream.writeFloat((float) point2D.getX());
    stream.writeFloat((float) point2D.getY());
    stream.writeObject(gp.getColor2());
    stream.writeBoolean(gp.isCyclic());
  }

  /**
   * Reads the object from the object input stream.
   *
   * @param stream the object input stream from where to read the serialized data.
   * @return the generated object.
   * @throws IOException            if reading the stream failed.
   * @throws ClassNotFoundException if serialized object class cannot be found.
   */
  public Object readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
  {
    final float x1 = stream.readFloat();
    final float y1 = stream.readFloat();
    final Color c1 = (Color) stream.readObject();
    final float x2 = stream.readFloat();
    final float y2 = stream.readFloat();
    final Color c2 = (Color) stream.readObject();
    final boolean isCyclic = stream.readBoolean();
    return new GradientPaint(x1, y1, c1, x2, y2, c2, isCyclic);
  }

  /**
   * The class of the object, which this object can serialize.
   *
   * @return the class of the object type, which this method handles.
   */
  public Class getObjectClass()
  {
    return GradientPaint.class;
  }
}
