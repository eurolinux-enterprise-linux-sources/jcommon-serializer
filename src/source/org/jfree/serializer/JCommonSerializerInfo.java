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
 * JCommonSerializerInfo
 * ------------
 */

package org.jfree.serializer;

import org.pentaho.reporting.libraries.base.versioning.ProjectInformation;

/**
 * Creation-Date: 23.10.2005, 18:49:39
 *
 * @author Thomas Morgner
 */
public class JCommonSerializerInfo extends ProjectInformation
{
  /**
   * The info singleton.
   */
  private static JCommonSerializerInfo singleton;

  /**
   * Returns the single instance of this class.
   *
   * @return The single instance of information about the JCommon library.
   */
  public static synchronized JCommonSerializerInfo getInstance()
  {
    if (singleton == null)
    {
      singleton = new JCommonSerializerInfo();
      singleton.initialize();
    }
    return singleton;
  }


  /**
   * Constructs an empty project info object.
   */
  private JCommonSerializerInfo()
  {
    super("jcommon-serializer", "JCommon-Serializer");
  }

  /**
   * Second step of the initialization.
   */
  private void initialize() 
  {
    setInfo("http://reporting.pentaho.org/jcommon-serializer/");
    setCopyright("(C)opyright 2006-2007, by Pentaho Corporation, Object Refinery Limited and Contributors");

    setLicenseName("LGPL");

    setBootClass(JCommonSerializerBoot.class.getName());
  }

}
