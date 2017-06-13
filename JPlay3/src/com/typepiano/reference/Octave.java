package com.typepiano.reference;

/**
 * 
 * For easy understanding and usage, The notes were arranged into octaves.
 * 
 * @usage Octave.O2.Cs will play C# Note of 2nd Octave.
 * @since May 2017
 * @version 2.0
 * @author saurabh.parihar
 *
 */
public enum Octave
{
      O1 (Note.C1, Note.Cx2, Note.D3, Note.Dx4, Note.E5, Note.F6, Note.Fx7, Note.G8, Note.Gx9, Note.A10, Note.Ax11, Note.B12, 1),
      O2 (Note.C13, Note.Cx14, Note.D15, Note.Dx16, Note.E17, Note.F18, Note.Fx19, Note.G20, Note.Gx21, Note.A22, Note.Ax23, Note.B24, 2),
	  O3 (Note.C25, Note.Cx26, Note.D27, Note.Dx28, Note.E29, Note.F30, Note.Fx31, Note.G32, Note.Gx33, Note.A34, Note.Ax35, Note.B36, 3),
	  O4 (Note.C37, Note.Cx38, Note.D39, Note.Dx40, Note.E41, Note.F42, Note.Fx43, Note.G44, Note.Gx45, Note.A46, Note.Ax47, Note.B48, 4),
	  O5 (Note.C49, Note.Cx50, Note.D51, Note.Dx52, Note.E53, Note.F54, Note.Fx55, Note.G56, Note.Gx57, Note.A58, Note.Ax59, Note.B60, 5),
	  O6 (Note.C61, null, null, null, null, null, null, null, null, null, null, null, 6);
      
	  private int octave;
	  public String C, Cs, D, Ds, E, F, Fs, G, Gs, A, As, B;

      Octave(String C, String Cs, String D, String Ds, String E, 
    		  String F, String Fs, String G, String Gs, String A,
    		  String As, String B, int octave){
    	  this.C = C;
    	  this.Cs = Cs;
    	  this.D = D;
    	  this.Ds = Ds;
    	  this.E = E;
    	  this.F = F;
    	  this.Fs = Fs;
    	  this.G = G;
    	  this.Gs = Gs;
    	  this.A = A;
    	  this.As = As;
    	  this.B = B;
          this.octave = octave;
      }

      int getOctave(){
          return this.octave;
      }
 }
