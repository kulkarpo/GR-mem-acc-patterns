import os
from .cffi_helpers import get_lib_handle
from cffi import FFI

__all__ = [
    'get_array_leaky',
    'get_array_safe',
]

_this_path = os.path.dirname(os.path.realpath(__file__))
_include_dir = _this_path

_build_dir = os.getenv('EXAMPLE_BUILD_DIR')
if _build_dir is None:
    _build_dir = _this_path
else:
    _build_dir = os.path.join(_build_dir, 'lib')

_lib = get_lib_handle(
    ['-DEXAMPLE_API='],
    'example.h',
    'example',
    _build_dir,
    _include_dir
)

get_array_leaky = _lib.get_array_leaky


def get_array_safe(length):
    ffi = FFI()
    array = ffi.new("double[]", length)
    _lib.get_array_safe(length, array)
    return array
